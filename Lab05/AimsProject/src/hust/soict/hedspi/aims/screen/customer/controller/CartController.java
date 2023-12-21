package hust.soict.hedspi.aims.screen.customer.controller;
import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
public class CartController {
    private Cart cart;
    private Store store;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlay;

    @FXML
    private TextField tfFilter;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText(" " + cart.getCost() + "  $");
    }

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof DigitalVideoDisc) {
            createDialog(((DigitalVideoDisc) media).play());
        } else if (media instanceof CompactDisc) {
            createDialog(((CompactDisc) media).play());
        }
    }

    public void createDialog(String playText) {
        JDialog dialog = new JDialog();
        JLabel label = new JLabel(playText, SwingConstants.CENTER);
        dialog.setLocationRelativeTo(null);
        dialog.add(label);
        dialog.setSize(400, 400);
        dialog.setVisible(true);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @FXML
    void btnOrderAction(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        createDialog(media.getTitle() + " - " + media.getCost() + " is ordered successfully");
        cart.removeMedia(media);
        costLabel.setText(" " + cart.getCost() + "  $");
    }

    @FXML
    public void initialize() throws LimitExceededException {
        cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Last Christmas", "music", "Selena", 100, 10.7f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Happy Birthday", "music", "Aqua", 100, 10.6f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Dragon Ball", "anime", "Akira", 100, 10.5f);
        Book book = new Book("Doraemon", "comic", 10.20f);
        Book book1 = new Book("I love you", "romance", 10f);
        cart.addMedia(dvd1);
        cart.addMedia(book1);
        cart.addMedia(book);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        costLabel.setText(" " + cart.getCost() + "  $");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                // TODO Auto-generated method stub
                updateButtonBar(newValue);
            }

        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // TODO Auto-generated method stub
                showFilteredMedia(arg2);
            }
        });

    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else
                btnPlay.setVisible(false);
        }
    }

    void showFilteredMedia(String textFilter) {
        FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered());
        tblMedia.setItems(filteredData);

        filteredData.setPredicate(media -> {
            if (textFilter == null || textFilter.isEmpty()) {
                return true;
            }
            if (radioBtnFilterId.isSelected()) {
                return media.getId() == Integer.parseInt(textFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(textFilter.toLowerCase());
            }
            return false;
        });
    }

}

package hust.soict.hedspi.aims.screen.customer.controller;
import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
public class ItemController {
    @FXML
    private Label lb1Cost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lb1Title;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {

    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        if (media instanceof DigitalVideoDisc) {
            createDialog(((DigitalVideoDisc) media).play());
        } else if (media instanceof CompactDisc) {
            createDialog(((CompactDisc) media).play());
        }
    }

    public void createDialog(String playText) {
        JDialog dialog = new JDialog();
        JLabel label = new JLabel(playText);
        dialog.setLocationRelativeTo(null);
        dialog.add(label);
        dialog.setSize(200, 200);
        dialog.setVisible(true);
    }

    private Media media;

    public void setData(Media media) {
        this.media = media;
        lb1Cost.setText(media.getCost() + "$");
        lb1Title.setText(media.getTitle());
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

}

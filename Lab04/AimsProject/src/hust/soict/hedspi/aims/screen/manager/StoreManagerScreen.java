package hust.soict.hedspi.aims.screen.manager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
public class StoreManagerScreen extends JFrame {
    Container cp = getContentPane();
    private static Store store;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewItem = new JMenuItem("View store");
        viewItem.addActionListener(e -> {
            addNewCenter(this.createCenter());
        });
        menu.add(viewItem);

        JMenu smUpdateStore = new JMenu("Update store");
        JMenuItem addBook = new JMenuItem("Add book");
        addBook.addActionListener(e -> {
            AddBookToStoreScreen bookScreen = new AddBookToStoreScreen();
            addNewCenter(bookScreen.createCenter());
        });
        smUpdateStore.add(addBook);

        JMenuItem addCd = new JMenuItem("Add CD");
        addCd.addActionListener(e -> {
            AddCompactDiscToStoreScreen cdScreen = new AddCompactDiscToStoreScreen();
            addNewCenter(cdScreen.createCenter());
        });
        smUpdateStore.add(addCd);

        JMenuItem addDvd = new JMenuItem("Add DVD");
        addDvd.addActionListener(e -> {
            AddDigitalVideoDiscToStoreScreen dvdScreen = new AddDigitalVideoDiscToStoreScreen();
            addNewCenter(dvdScreen.createCenter());
        });
        smUpdateStore.add(addDvd);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;

    }

    JPanel createCenter() {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public StoreManagerScreen(Store store) {
        this.store = store;
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setLocationRelativeTo(null);
        setSize(1024, 768);
    }

    public void addNewCenter(JPanel panel) {
        LayoutManager layout = cp.getLayout();
        Component centerComponent = ((BorderLayout) layout).getLayoutComponent(cp, BorderLayout.CENTER);
        cp.remove(centerComponent);
        cp.add(panel, BorderLayout.CENTER);
        cp.revalidate();
        cp.repaint();

    }

    public static void main(String[] args) {
        store = new Store();
        store.addMedia(new Book("The Promised Neverland", "Shirai Kaiu", 15.05f));
        store.addMedia(new Book("Black Clover", "Tabata Yuki", 12.05f));
        store.addMedia(new Book("Dragon Ball", "Akira Toriyama", 14.05f));
        store.addMedia(new Book("Dr.Stone", "Riichiro Inagaki", 10.05f));
        store.addMedia(new CompactDisc("End Game", "Marvel Studio", 20f, 100, "", "Walt Disney"));
        store.addMedia(new Book("Waiting For You", "Mono", 12.05f));
        store.addMedia(new DigitalVideoDisc("How You Like That", "Black Pink", "SM", 150, 10f));
        new StoreManagerScreen(store);
    }
}

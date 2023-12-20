package hust.soict.hedspi.aims.screen.manager;
import javax.swing.JButton;
import javax.swing.JPanel;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
    JPanel createCenter() {
        JPanel panel = super.createCenter();
        JButton btnAdd = new JButton("Add to the store");
        panel.add(btnAdd);
        return panel;
    }
}

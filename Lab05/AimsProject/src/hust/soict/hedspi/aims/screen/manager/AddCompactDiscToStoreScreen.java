package hust.soict.hedspi.aims.screen.manager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    JPanel createCenter() {
        JPanel panel = super.createCenter();

        JTextField lengthField = new JTextField("Input length : ");
        lengthField.setMaximumSize(new Dimension(500, 30));
        lengthField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        lengthField.setMargin(new Insets(10, 10, 10, 10));

        JTextField directorField = new JTextField("Input director : ");
        directorField.setMaximumSize(new Dimension(500, 30));
        directorField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        directorField.setMargin(new Insets(10, 10, 10, 10));

        JTextField artistField = new JTextField("Input artist : ");
        artistField.setMaximumSize(new Dimension(500, 30));
        artistField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        artistField.setMargin(new Insets(10, 10, 10, 10));

        panel.add(lengthField);
        panel.add(directorField);
        panel.add(artistField);

        JButton btnAdd = new JButton("Add to the store");
        panel.add(btnAdd);

        return panel;
    }
}

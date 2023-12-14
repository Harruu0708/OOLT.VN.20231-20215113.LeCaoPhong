package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AddItemToStoreScreen extends JFrame {
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JTextField titleField = new JTextField("Input title : ");
        titleField.setMaximumSize(new Dimension(500, 30));
        titleField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        titleField.setMargin(new Insets(10, 10, 10, 10));

        JTextField authorField = new JTextField("Input author : ");
        authorField.setMaximumSize(new Dimension(500, 30));
        authorField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 20, 0, 0)));

        JTextField costField = new JTextField("Input cost : ");
        costField.setMaximumSize(new Dimension(500, 30));
        costField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(0, 20, 0, 0)));

        center.add(titleField);
        center.add(authorField);
        center.add(costField);

        return center;

    }
}

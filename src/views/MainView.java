package views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel contentPanel;


    public MainView() {
        this.contentPanel = new JPanel(new FlowLayout());
        drawWindow();
        addComponentsToFrame();
    }

    private void addComponentsToFrame() {
        contentPanel.add(new Button("Button 1"));
    }

    private void drawWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setPreferredSize(new Dimension(500, 500));
        setResizable(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        add(contentPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddAppointmentView extends AbstractAddEditView {
    private JButton addButton;

    public AddAppointmentView() {
        super();
    }

    @Override
    public void drawWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setTitle("Add Appointment");
        setPreferredSize(new Dimension(300, 250));
        setResizable(false);
        setLocationRelativeTo(null);

        add(super.getMainContentPane());
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void addComponentsToPanels() {
        super.getButtonContentPane().add(this.addButton);
        super.addComponentsToPanels();
    }

    @Override
    public void initializeComponents() {
        super.initializeComponents();
        this.addButton = new JButton("Add");
    }

    public void addAddButtonListener(ActionListener listenerForAddButton) {
        this.addButton.addActionListener(listenerForAddButton);
    }

}

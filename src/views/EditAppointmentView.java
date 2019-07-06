package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditAppointmentView extends AbstractAddEditView {
    private JButton saveButton;

    public EditAppointmentView() {
        super();
    }

    @Override
    public void initializeComponents() {
        super.initializeComponents();
        this.saveButton = new JButton("Save");
    }

    @Override
    public void drawWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setTitle("Edit Appointment");
        setPreferredSize(new Dimension(300, 280));
        setResizable(false);
        setLocationRelativeTo(null);

        add(super.getMainContentPane());
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void addComponentsToPanels() {
        super.getButtonContentPane().add(this.saveButton);
        super.addComponentsToPanels();
    }

    public void addSaveButtonListener(ActionListener listenerForSaveButton) {
        this.saveButton.addActionListener(listenerForSaveButton);
    }
}

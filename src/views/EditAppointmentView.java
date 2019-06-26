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

        add(super.mainContentPane);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void addComponentsToPanels() {
        super.addComponentsToPanels();

        super.buttonContentPane.add(this.saveButton);
    }

    public void addSaveButtonListener(ActionListener listenerForSaveButton) {
        this.saveButton.addActionListener(listenerForSaveButton);
    }
}

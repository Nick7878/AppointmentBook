package controllers;

import models.Appointment;
import models.AppointmentAndContactData;
import models.Contact;
import views.AbstractAddEditView;
import views.AddAppointmentView;
import views.EditAppointmentView;
import views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainController {
    private AppointmentAndContactData appointmentAndContactData;
    private MainView mainView;

    public  MainController() {
        this.appointmentAndContactData = new AppointmentAndContactData();
        this.mainView = new MainView();
    }

    public MainController(MainView mView, AppointmentAndContactData theModel) {
        this.appointmentAndContactData = theModel;
        this.mainView = mView;
        this.mainView.buildView(appointmentAndContactData.getAppointments());

        this.mainView.addAddAppointmentButtonListener(new AddAppointmentButtonListener());
        this.mainView.addEditAppointmentButtonListener(new EditAppointmentButtonListener());
        this.mainView.addDeleteAppointmentButtonListener(new DeleteAppointmentButtonListener());
        this.mainView.addContactsButtonListener(new ContactsButtonListener());

    }

    class AddAppointmentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddAppointmentView theAddAppointmentView = new AddAppointmentView();
            AddAppointmentController theAddAppointmentController = new AddAppointmentController(theAddAppointmentView, mainView, appointmentAndContactData);
            theAddAppointmentView.setVisible(true);
        }

    }

    class EditAppointmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Edit Button Tapped");
            if(mainView.getSelectedRowIndexFromTable() == -1) {
                JOptionPane.showMessageDialog(mainView, "Please select an appointment to edit", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                EditAppointmentView theEditAppointmentView = new EditAppointmentView();
                Appointment appointmentToEdit = appointmentAndContactData.getAppointments().get(mainView.getSelectedRowIndexFromTable());
                EditAppointmentController theEditAppointmentController = new EditAppointmentController(theEditAppointmentView, mainView, appointmentAndContactData, appointmentToEdit);
                theEditAppointmentView.setVisible(true);
            }
        }
    }

    class DeleteAppointmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Delete Button Tapped");
            if(mainView.getSelectedRowIndexFromTable() == -1) {
                JOptionPane.showMessageDialog(mainView, "Please select an appointment to delete", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this appointment?");
                if(confirmResult == JOptionPane.YES_OPTION) {
                    Appointment appointmentToBeDeleted = mainView.deleteAppointmentFromSelectedRow(appointmentAndContactData.getAppointments());
                    appointmentAndContactData.removeAppointmentFromAppointments(appointmentToBeDeleted);
                    appointmentAndContactData.getAppointmentDAO().deleteAppointment(appointmentToBeDeleted);
                }
            }
        }
    }

    class ContactsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Contact Button Tapped");
        }
    }
}

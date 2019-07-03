package controllers;

import models.Appointment;
import models.AppointmentAndContactData;
import views.EditAppointmentView;
import views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAppointmentController {
    private EditAppointmentView editView;
    private AppointmentAndContactData model;
    private MainView mainView;
    private Appointment appointmentToEdit;

    public EditAppointmentController() {
        this.editView = new EditAppointmentView();
        this.model = new AppointmentAndContactData();
        this.mainView = new MainView();
    }

    public EditAppointmentController(EditAppointmentView eView, MainView mView, AppointmentAndContactData model, Appointment app) {
        this.editView = eView;
        this.mainView = mView;
        this.model = model;
        this.appointmentToEdit = app;

        this.editView.buildView();
        this.fillOutFields();

        this.editView.addSaveButtonListener(new SaveButtonListener());
        this.editView.addCancelButtonListener(new CancelButtonListener());
    }

    private void fillOutFields() {
        this.editView.setNameInput(appointmentToEdit.getName());
        this.editView.setServiceInput(appointmentToEdit.getService());
        this.editView.setPhoneNumberInput(appointmentToEdit.getPhoneNum());
        this.editView.setTimeInput(appointmentToEdit.getTime());
        this.editView.setDateInput(appointmentToEdit.getDate());
        this.editView.setStylistInput(appointmentToEdit.getStylist());
    }

    class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(editView.getNameInput().length() > 0 && editView.getServiceInput().length() > 0 && editView.getPhoneNumberInput().length() > 0 &&
                    editView.getTimeInput().length() > 0 && editView.getDateInput().length() > 0 && editView.getStylistInput().length() > 0) {

                appointmentToEdit.setName(editView.getNameInput());
                appointmentToEdit.setService(editView.getServiceInput());
                appointmentToEdit.setPhoneNum(editView.getPhoneNumberInput());
                appointmentToEdit.setTime(editView.getTimeInput());
                appointmentToEdit.setDate(editView.getDateInput());
                appointmentToEdit.setStylist(editView.getStylistInput());

//                int generatedID = model.getAppointmentDAO().insertAppointment(app);
//                if(generatedID != -1) {
//                    app.setId(generatedID);
//                }
                JOptionPane.showMessageDialog(editView, "Appointment successfully saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
                editView.dispose();
                //model.addAppointmentToAppointments(app);
                //mainView.updateTableValues(app);
                model.setElementAtIndex(mainView.getSelectedRowIndexFromTable(), appointmentToEdit);
                model.getAppointmentDAO().updateAppointment(appointmentToEdit);
                mainView.refreshTableValues();
            } else {
                JOptionPane.showMessageDialog(editView, "All fields must have a value entered.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    class CancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editView.dispose();
        }
    }

}

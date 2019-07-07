package controllers;

import models.Appointment;
import models.AppointmentAndContactData;
import views.AddAppointmentView;
import views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAppointmentController {
    private AddAppointmentView addView;
    private AppointmentAndContactData model;
    private MainView mainView;

    public AddAppointmentController() {
        this.addView = new AddAppointmentView();
        this.model = new AppointmentAndContactData();
        this.mainView = new MainView();
    }

    public AddAppointmentController(AddAppointmentView view, MainView mainView, AppointmentAndContactData model) {
        this.addView = view;
        this.mainView = mainView;
        this.model = model;

        this.addView.buildView();

        this.addView.addAddButtonListener(new AddButtonListener());
        this.addView.addCancelButtonListener(new CancelButtonListener());
    }

    class AddButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(addView.getNameInput().length() > 0 && addView.getServiceInput().length() > 0 && addView.getPhoneNumberInput().length() > 0 &&
            addView.getTimeInput().length() > 0 && addView.getDateInput().length() > 0 && addView.getStylistInput().length() > 0) {

                Appointment app = new Appointment(addView.getNameInput(), addView.getServiceInput(), addView.getPhoneNumberInput(), addView.getTimeInput(), addView.getDateInput(), addView.getStylistInput());
                int generatedID = model.getAppointmentDAO().insertAppointment(app);
                if(generatedID != -1) {
                    app.setId(generatedID);
                }
                JOptionPane.showMessageDialog(addView, "Appointment successfully added.", "Success", JOptionPane.INFORMATION_MESSAGE);
                addView.dispose();
                model.addAppointmentToAppointments(app);
                mainView.updateTableValuesAfterAdd(app);
            } else {
                JOptionPane.showMessageDialog(addView, "All fields must have a value entered.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    class CancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addView.dispose();
        }
    }
}

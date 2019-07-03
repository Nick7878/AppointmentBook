package controllers;

import models.AppointmentAndContactData;
import views.EditAppointmentView;
import views.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAppointmentController {
    private EditAppointmentView editView;
    private AppointmentAndContactData model;
    private MainView mainView;

    public EditAppointmentController() {
        this.editView = new EditAppointmentView();
        this.model = new AppointmentAndContactData();
        this.mainView = new MainView();
    }

    public EditAppointmentController(EditAppointmentView eView, MainView mView, AppointmentAndContactData model) {
        this.editView = eView;
        this.mainView = mView;
        this.model = model;

        this.editView.buildView();

        this.editView.addSaveButtonListener(new SaveButtonListener());
        this.editView.addCancelButtonListener(new CancelButtonListener());
    }

    class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

    class CancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            editView.dispose();
        }
    }

}

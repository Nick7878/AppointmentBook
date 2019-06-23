package controllers;

import models.Appointment;
import models.AppointmentAndContactData;
import models.Contact;
import views.AddAppointmentView;
import views.MainView;

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
    }

    class AddAppointmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddAppointmentView theAddAppointmentView = new AddAppointmentView();
            theAddAppointmentView.setVisible(true);
        }

    }
}

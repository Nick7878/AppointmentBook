package controllers;

import models.Appointment;
import models.AppointmentAndContactData;
import models.Contact;
import views.MainView;

import java.util.List;

public class MainController {
    private AppointmentAndContactData appointmentAndContactData;
    private MainView mainView;

    public  MainController() {
        appointmentAndContactData = new AppointmentAndContactData();
        mainView = new MainView();
    }

    public MainController(MainView mView) {
        appointmentAndContactData = new AppointmentAndContactData();
        mainView = mView;
        mainView.buildView(appointmentAndContactData.getAppointments());
    }


}

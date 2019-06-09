package models;

import java.util.List;

public class AppointmentAndContactData {
    private List<Appointment> appointments;
    private List<Contact> contacts;
    private  AppointmentDAO appointmentDAO;
    private  ContactDAO contactDAO;

    public  AppointmentAndContactData(){
        appointmentDAO = new AppointmentDAO();
        contactDAO = new ContactDAO();
        appointments = appointmentDAO.findAll();
        contacts = contactDAO.findAll();
    }

    public List<Contact> getContacts(){
        return contacts;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}

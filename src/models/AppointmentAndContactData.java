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

    public Appointment getAppointmentFromAppointmentsListWithIndex(int index) {
        return appointments.get(index);
    }

    public AppointmentDAO getAppointmentDAO() {
        return appointmentDAO;
    }

    public ContactDAO getContactDAO() {
        return contactDAO;
    }

    public void addAppointmentToAppointments(Appointment app) {
        appointments.add(app);
    }

    public void removeAppointmentFromAppointments(Appointment app) {
        appointments.remove(app);
    }

    public void setElementAtIndex(int index, Appointment app) {
        appointments.set(index, app);
    }
}

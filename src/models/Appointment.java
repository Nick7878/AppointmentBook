package models;

import interfaces.AppointmentDAOInterface;

import java.util.List;

public class Appointment{
    private Integer id;
    private String name;
    private String service;
    private String phoneNum;
    private String time;
    private String date;
    private String stylist;
    private Integer contact_id;
    private AppointmentDAOInterface appointmentDAO;

    public Appointment(String name, String service, String phoneNum, String time, String date, String stylist){
        this.name = name;
        this.service = service;
        this.phoneNum = phoneNum;
        this.time = time;
        this.date = date;
        this.stylist = stylist;
        this.contact_id = null;
        appointmentDAO = new AppointmentDAO();
    }

    public Appointment(Integer id, String name, String service, String phoneNum, String time, String date, String stylist, Integer contact_id) {
        this.id = id;
        this.name = name;
        this.service = service;
        this.phoneNum = phoneNum;
        this.time = time;
        this.date = date;
        this.stylist = stylist;
        this.contact_id = contact_id;
        appointmentDAO = new AppointmentDAO();
    }

    public Appointment() {
        appointmentDAO = new AppointmentDAO();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStylist() {
        return stylist;
    }

    public void setStylist(String stylist) {
        this.stylist = stylist;
    }

    public String[] putAppointmentDataInArray() {
        String[] appointmentDataArray = {getName(), getService(), getPhoneNum(), getTime(), getDate(), getStylist()};
        return appointmentDataArray;
    }

    public void setAppointmentWithArray(String[] appointmentFields) {
        this.setName(appointmentFields[0]);
        this.setService(appointmentFields[1]);
        this.setPhoneNum(appointmentFields[2]);
        this.setTime(appointmentFields[3]);
        this.setDate(appointmentFields[4]);
        this.setStylist(appointmentFields[5]);
    }
}

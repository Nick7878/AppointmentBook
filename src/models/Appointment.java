package models;

import interfaces.AppointmentDAOInterface;

public class Appointment extends Contact{
    private Integer id;
    private String service;
    private String time;
    private String date;
    private String stylist;

    public Appointment(String service, String time, String date, String stylist){
        this.service = service;
        this.time = time;
        this.date = date;
        this.stylist = stylist;
    }

    public Appointment(Integer id, String service, String time, String date, String stylist) {
        this.id = id;
        this.service = service;
        this.time = time;
        this.date = date;
        this.stylist = stylist;
    }

    public Appointment() {

    }

    public Integer getId() {
        return id;
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

}

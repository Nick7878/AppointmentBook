package models;

import interfaces.AppointmentDAOInterface;

public class Appointment extends Contact{
    private Integer id;
    private String service;
    private String time;
    private String date;
    private String stylist;
    private Integer contact_id;

    public Appointment(String service, String time, String date, String stylist){
        this.service = service;
        this.time = time;
        this.date = date;
        this.stylist = stylist;
        this.contact_id = null;
    }

    public Appointment(Integer id, String service, String time, String date, String stylist, Integer contact_id) {
        this.id = id;
        this.service = service;
        this.time = time;
        this.date = date;
        this.stylist = stylist;
        this.contact_id = contact_id;
    }

    public Appointment(Integer id, String service, String time, String date, String stylist) {
        this.id = id;
        this.service = service;
        this.time = time;
        this.date = date;
        this.stylist = stylist;
        this.contact_id = null;
    }

    public Appointment() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getContact_id() {
        return contact_id;
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

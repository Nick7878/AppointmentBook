package models;

import interfaces.AppointmentDAOInterface;

public class Appointment extends Contact{
    private int id;
    private String service;
    private String time;
    private String date;
    private String stylist;

    public Appointment(String serv, String tim, String d, String style){
        service = serv;
        time = tim;
        date = d;
        stylist = style;
    }

    public int getId() {
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

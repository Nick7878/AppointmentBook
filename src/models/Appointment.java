package models;

import interfaces.AppointmentDAOInterface;

public class Appointment{
    private Integer id;
    private String name;
    private String service;
    private String phoneNum;
    private String time;
    private String date;
    private String stylist;
    private Integer contact_id;

    public Appointment(String name, String service, String phoneNum, String time, String date, String stylist){
        this.name = name;
        this.service = service;
        this.phoneNum = phoneNum;
        this.time = time;
        this.date = date;
        this.stylist = stylist;
        this.contact_id = null;
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
    }

    public Appointment() {

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

}

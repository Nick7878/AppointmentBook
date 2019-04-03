package models;

import interfaces.ContactDAOInterface;

public class Contact {
    private Integer id;
    private String name;
    private String phoneNum;

    public Contact(Integer id, String name, String phoneNum) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public Contact(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public Contact() {

    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}

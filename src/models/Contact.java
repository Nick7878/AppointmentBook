package models;

import interfaces.ContactDAOInterface;

public class Contact {
    private String name;
    private String phoneNum;

    public Contact(String n, String p){
        name = n;
        phoneNum = p;
    }

    public Contact() {
        name = "";
        phoneNum = "";
    }

    public String getName(){
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }


}

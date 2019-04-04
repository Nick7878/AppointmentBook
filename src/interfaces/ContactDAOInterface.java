package interfaces;

import models.Contact;

import java.util.List;

public interface ContactDAOInterface<T> {

    List<Contact> findAll();
    Contact findById(int id);
    List<Contact> findByName(String name);
    List<Contact> findByPhoneNum(String phoneNum);
    List<Contact> findByNameAndPhoneNum(String name, String phoneNum);
    boolean insertContact(Contact contact);
    boolean updateContact(Contact contact,String name, String phoneNum);
    boolean deleteContact(int id);
}

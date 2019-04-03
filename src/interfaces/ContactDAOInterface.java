package interfaces;

import models.Contact;

import java.util.List;

public interface ContactDAOInterface {

    List<Contact> findAll();
    List<Contact> findById();
    List<Contact> findByName();
//    List<Contact> findByPhoneNum();
    boolean insertContact(Contact contact);
    boolean updateContact(Contact contact);
    boolean deleteEmployee(Contact contact);
}

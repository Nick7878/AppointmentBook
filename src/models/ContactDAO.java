package models;

import interfaces.ContactDAOInterface;
import models.ConnectionFactory;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class ContactDAO implements ContactDAOInterface<Contact> {
    private List<Contact> Contacts = new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");

            List<Contact> listOfContacts = new ArrayList<>();

            if(rs.next()) {
                listOfContacts.add(extractContactFromResultSet(rs));
            }

            return listOfContacts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Contact findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE contact_id = " + id);

            Contact contact = new Contact();
            if(rs.next()) {
                contact = extractContactFromResultSet(rs);
            }
            return contact;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
//
//    @Override
//    public List<Contact> findByName(String name) {
//        Connection connection = ConnectionFactory.getConnection();
//        try{
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE name = " + name);
//
//            List<Contact> listOfContacts = new ArrayList<>();
//
//            if(rs.next()) {
//                listOfContacts.add(extractContactFromResultSet(rs));
//            }
//            return listOfContacts;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Contact> findByPhoneNum(String phoneNum) {
//        Connection connection = ConnectionFactory.getConnection();
//        try{
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE phoneNum = " + phoneNum);
//
//            List<Contact> listOfContacts = new ArrayList<>();
//
//            if(rs.next()) {
//                listOfContacts.add(extractContactFromResultSet(rs));
//            }
//            return listOfContacts;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Contact> findByNameAndPhoneNum(String name, String phoneNum) {
//        Connection connection = ConnectionFactory.getConnection();
//        try{
//            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM contacts WHERE name = ? AND phoneNum = ?");    //With multiple parameters, it's better to use PreparedStatement instead of Statement
//            pstmt.setString(1, name);
//            pstmt.setString(2, phoneNum);
//            ResultSet rs = pstmt.executeQuery();
//
//            List<Contact> listOfContacts = new ArrayList<>();
//            if(rs.next()) {
//                listOfContacts.add(extractContactFromResultSet(rs));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean insertContact(Contact contact) {
//        Connection connection = ConnectionFactory.getConnection();
//        try{
//            PreparedStatement pstmt = connection.prepareStatement("INSERT  INTO contacts VALUES (NULL, ?, ?)");
//            pstmt.setString(1, contact.getName());
//            pstmt.setString(2, contact.getPhoneNum());
//            int i = pstmt.executeUpdate();
//
//            if(i == 1) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean updateContact(Contact contact) {
//        Connection connection = ConnectionFactory.getConnection();
//        try{
//            PreparedStatement pstmt = connection.prepareStatement("UPDATE contacts SET name = ?, phoneNum = ? WHERE contact_id = ?");
//            pstmt.setString(1, contact.getName());
//            pstmt.setString(2, contact.getPhoneNum());
//            pstmt.setInt(3, contact.getId());
//            int i = pstmt.executeUpdate();
//
//            if(i == 1) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteContact(int id) {
//        Connection connection = ConnectionFactory.getConnection();
//        try{
//            Statement stmt = connection.createStatement();
//            int i = stmt.executeUpdate("DELETE FROM contacts WHERE contact_id = " + id);
//
//            if(i == 1) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }

    private Contact extractContactFromResultSet(ResultSet rs) throws SQLException {
        Contact contact = new Contact();

        contact.setId(rs.getInt("contact_id"));
        contact.setName(rs.getString("name"));
        contact.setPhoneNum(rs.getString("phoneNum"));

        return contact;
    }


}

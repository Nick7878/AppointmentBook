import interfaces.ContactDAOInterface;
import models.Contact;
import models.ContactDAO;
import views.MainView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[]args) {
//        String url = "jdbc:mysql://localhost:3306/appointmentbook?useSSL=false";
//        String user = "Nick78";
//        String password = "gameboy*1";
//
//        String query = "SELECT * from contacts";
//
//        try(Connection con = DriverManager.getConnection(url, user, password)){
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//
//            if(rs.next()) {
//                System.out.println(rs.getString(1));
//            }
//
//        } catch (SQLException ex) {
//
//            Logger lgr = Logger.getLogger(Main.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
//        }
//        ContactDAOInterface contactDAO = new ContactDAO();
//        List<Contact> contacts = contactDAO.findAll();
//        List<Contact> contacts2 = contactDAO.findByName("Kyle");
//        List<Contact> contacts3 = contactDAO.findByPhoneNum("609-787-7878");
//        List<Contact> contacts4 = contactDAO.findByNameAndPhoneNum("Jack", "609-797-7979");

        //contactDAO.insertContact(new Contact("Kyle", "609-808-8080"));
        //contactDAO.updateContact(contacts2.get(0), "Jake", contacts2.get(0).getPhoneNum());
        //contactDAO.deleteContact(contacts2.get(0).getId());


//        for(Contact contact : contacts){
//            System.out.println(contact.getName() + ", " + contact.getPhoneNum());
//        }
//        for(Contact contact : contacts2){
//            System.out.println(contact.getName() + ", " + contact.getPhoneNum());
//        }
//        for(Contact contact : contacts3){
//            System.out.println(contact.getName() + ", " + contact.getPhoneNum());
//        }
//        for(Contact contact : contacts4){
//            System.out.println(contact.getName() + ", " + contact.getPhoneNum());
//        }

        //System.out.println(contactDAO.findById(1).getName());

        MainView mv = new MainView();
    }
}

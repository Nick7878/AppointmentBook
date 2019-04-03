import interfaces.ContactDAOInterface;
import models.Contact;
import models.ContactDAO;

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
        ContactDAOInterface contactDAO = new ContactDAO();
        List<Contact> contacts = contactDAO.findAll();
        for(Contact contact : contacts){
            System.out.println(contact.getName() + ", " + contact.getPhoneNum());
        }

        System.out.println(contactDAO.findById(1).getName());

    }
}

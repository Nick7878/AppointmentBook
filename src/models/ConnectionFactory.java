package models;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/appointmentbook?useSSL=false";
    public static final String USER = "Nick78";
    public static final String PASS = "gameboy*1";

    public static Connection getConnection() {
        try{
            DriverManager.registerDriver(new Driver());
            System.out.println("Success!");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    //Test Connection
//    public static void main(String[] args) {
//        Connection con = ConnectionFactory.getConnection();
//    }
}

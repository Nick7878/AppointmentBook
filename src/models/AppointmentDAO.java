package models;

import interfaces.AppointmentDAOInterface;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO implements AppointmentDAOInterface<Appointment> {

    public List<Appointment> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM appointments");
            List<Appointment> listOfAppointments = new ArrayList<>();

            while(rs.next()) {
                listOfAppointments.add(extractAppointmentFromResultSet(rs));
            }
            rs.close();
            stmt.close();
            return listOfAppointments;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public Appointment findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM appointments WHERE appointment_id = " + id);
            Appointment appointment = new Appointment();
            if(rs.next()) {
                appointment = extractAppointmentFromResultSet(rs);
            }
            rs.close();
            stmt.close();
            return appointment;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Appointment> findByContactId(int contact_id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM appointments WHERE contact_id = ?");
            pstmt.setInt(1, contact_id);
            ResultSet rs = pstmt.executeQuery();
            List<Appointment> listOfAppointments = new ArrayList<>();

            while(rs.next()) {
                listOfAppointments.add(extractAppointmentFromResultSet(rs));
            }
            pstmt.close();
            rs.close();
            return listOfAppointments;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Appointment> findByService(String service) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM appointments WHERE service = ?");
            pstmt.setString(1, service);
            ResultSet rs = pstmt.executeQuery();
            List<Appointment> listOfAppointments = new ArrayList<>();
            while(rs.next()) {
                listOfAppointments.add(extractAppointmentFromResultSet(rs));
            }
            pstmt.close();
            rs.close();
            return listOfAppointments;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<Appointment> findByDate(String date) {
        Connection connection = ConnectionFactory.getConnection();
        List<Appointment> listOfAppointments = new ArrayList<>();
        try{
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM appointments WHERE date = ?");
            pstmt.setString(1, date);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                listOfAppointments.add(extractAppointmentFromResultSet(rs));
            }
            pstmt.close();
            rs.close();
            return listOfAppointments;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listOfAppointments;
    }

    public List<Appointment> findByStylist(String stylist) {
        Connection connection = ConnectionFactory.getConnection();
        List<Appointment> listOfAppointments = new ArrayList<>();
        try{
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM appointments WHERE stylist = ?");
            pstmt.setString(1, stylist);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                listOfAppointments.add(extractAppointmentFromResultSet(rs));
            }
            pstmt.close();
            rs.close();
            return listOfAppointments;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listOfAppointments;
    }

    public int insertAppointment(Appointment appointment) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO appointments(name, service, phoneNum, time, date, stylist) VALUES(?, ?, ?, ?, ? ,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, appointment.getName());
            pstmt.setString(2, appointment.getService());
            pstmt.setString(3, appointment.getPhoneNum());
            pstmt.setString(4, appointment.getTime());
            pstmt.setString(5, appointment.getDate());
            pstmt.setString(6, appointment.getStylist());
            //ConactID will be null for now, until I fully implement contacts
            //pstmt.setInt(7, appointment.getContact_id());

            int i = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            if(i == 1) {
                return rs.getInt(1);
            }
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public boolean updateAppointment(Appointment appointment) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            PreparedStatement pstmt = connection.prepareStatement("UPDATE appointments SET name = ?, service = ?, phoneNum = ?, time = ?, date = ?, stylist = ?, contact_id = ? WHERE appointment_id = ?");
            pstmt.setString(1, appointment.getName());
            pstmt.setString(2, appointment.getService());
            pstmt.setString(3, appointment.getPhoneNum());
            pstmt.setString(4, appointment.getTime());
            pstmt.setString(5, appointment.getDate());
            pstmt.setString(6, appointment.getStylist());
            pstmt.setInt(7, appointment.getContact_id());
            pstmt.setInt(8, appointment.getId());
            int i = pstmt.executeUpdate();
            if(i == 1) {
                return true;
            }
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteAppointment(Appointment appointment) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM appointments WHERE appointment_id = ?");
            pstmt.setInt(1, appointment.getId());
            int i = pstmt.executeUpdate();
            if(i == 1) {
                return true;
            }
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    private Appointment extractAppointmentFromResultSet(ResultSet rs) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setId(rs.getInt("appointment_id")); //Column name may need to be changed
        appointment.setName(rs.getString("name"));
        appointment.setService(rs.getString("service"));
        appointment.setPhoneNum(rs.getString("phoneNum"));
        appointment.setTime(rs.getString("time"));
        appointment.setDate(rs.getString("date"));
        appointment.setStylist(rs.getString("stylist"));
        appointment.setContact_id(rs.getInt("contact_id"));

        return appointment;
    }
}

package models;

import interfaces.AppointmentDAOInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    private Appointment extractAppointmentFromResultSet(ResultSet rs) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setId(rs.getInt("appointment_id")); //Column name may need to be changed
        appointment.setService(rs.getString("service"));
        appointment.setTime(rs.getString("time"));
        appointment.setDate(rs.getString("date"));
        appointment.setStylist(rs.getString("stylist"));

        return appointment;
    }
}

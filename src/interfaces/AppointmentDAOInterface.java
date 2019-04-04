package interfaces;

import models.Appointment;
import models.Contact;

import java.util.List;

public interface AppointmentDAOInterface<T> {

    List<Appointment> findAll();
    Appointment findById(int id);
    List<Appointment> findByService(String service);
    List<Appointment> findByDate(String date);
    List<Appointment> findByStylist(String stylist);
    boolean insertAppointment(Appointment app);
    boolean updateAppointment(Appointment app);
    boolean deleteAppointment(Appointment app);
}

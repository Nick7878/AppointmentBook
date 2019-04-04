package interfaces;

import models.Appointment;
import models.Contact;

import java.util.List;

public interface AppointmentDAOInterface<T> {

    List<Appointment> findAll();
    Appointment findById(int id);
    List<Appointment> findByService();
    List<Appointment> findByDate();
    List<Appointment> findByStylist();
    boolean insertAppointment(Appointment app);
    boolean updateAppointment(Appointment app);
    boolean deleteAppointment(Appointment app);
}

package interfaces;

import models.Appointment;
import models.Contact;

import java.util.List;

public interface AppointmentDAOInterface {

    List<Appointment> findAll();
    List<Appointment> findById();
    List<Appointment> findByService();
    List<Appointment> findByDate();
    List<Appointment> findByStylist();
    boolean insertAppointment(Appointment app);
    boolean updateAppointment(Appointment app);
    boolean deleteAppointment(Appointment app);
}

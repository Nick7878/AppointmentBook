package views;

import models.Appointment;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;

public class MainView extends JFrame {
    private JPanel contentPanel;
    private JTable appointmentTable;
    private JButton addAppointmentButton;
    private JButton editAppointmentButton;
    private JButton deleteAppointmentButton;
    private JButton contactsButton;


    public MainView() {
        this.contentPanel = new JPanel(new FlowLayout());
        this.addAppointmentButton = new JButton("Add Appointment");
        this.editAppointmentButton = new JButton("Edit Appointment");
        this.deleteAppointmentButton = new JButton("Delete Appointment");
        this.contactsButton = new JButton(("Contacts"));
    }

    public void buildView(List<Appointment> appointments) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setUpAppointmentTable(appointments);
                drawWindow();
                addComponentsToFrame();
            }
        });
    }

    public void addComponentsToFrame() {
        contentPanel.add(addAppointmentButton);
        contentPanel.add(editAppointmentButton);
        contentPanel.add(deleteAppointmentButton);
        contentPanel.add(contactsButton);
        contentPanel.add(new JScrollPane(appointmentTable));
    }

    private void drawWindow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setTitle("Appointment Book");
        setPreferredSize(new Dimension(500, 500));
        setResizable(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        add(contentPanel, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setUpAppointmentTable(List<Appointment> appointments) {
        String[] columnNames = {"Name", "Service", "Phone Number", "Time", "Date", "Stylist"};

        appointmentTable = new JTable(setUpAppointmentTableValues(appointments), columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableColumnModel columnModel = appointmentTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(100);
        appointmentTable.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(appointmentTable);

    }

    private String[][] setUpAppointmentTableValues(List<Appointment> appointments) {
        String[][] appointmentData = new String[appointments.size()][6];
        for(int numberOfAppointments = 0; numberOfAppointments < appointments.size(); numberOfAppointments++) {
            for(int columns = 0; columns < 6; columns++) {
                switch(columns) {
                    case 0:
                        appointmentData[numberOfAppointments][columns] = appointments.get(numberOfAppointments).getName();
                        break;
                    case 1:
                        appointmentData[numberOfAppointments][columns] = appointments.get(numberOfAppointments).getService();
                        break;
                    case 2:
                        appointmentData[numberOfAppointments][columns] = appointments.get(numberOfAppointments).getPhoneNum();
                        break;
                    case 3:
                        appointmentData[numberOfAppointments][columns] = appointments.get(numberOfAppointments).getTime();
                        break;
                    case 4:
                        appointmentData[numberOfAppointments][columns] = appointments.get(numberOfAppointments).getDate();
                        break;
                    case 5:
                        appointmentData[numberOfAppointments][columns] = appointments.get(numberOfAppointments).getStylist();
                        break;
                }
            }
        }
        return appointmentData;
    }
}

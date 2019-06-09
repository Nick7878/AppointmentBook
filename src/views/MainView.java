package views;

import models.Appointment;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;

public class MainView extends JFrame {
    private JPanel contentPanel;
    private JTable appointmentTable;


    public MainView() {
        this.contentPanel = new JPanel(new FlowLayout());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //setUpAppointmentTable();
                drawWindow();
                //addComponentsToFrame();
            }
        });
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
        contentPanel.add(new Button("Add Appointment"));
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
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Will take in a List parameter of type Appointment. For now, just placeholder data
    public void setUpAppointmentTable(List<Appointment> appointments) {
        String[][] placeholderData = {
//                {"Nick", "Cut", "787-787-7878", "3:40 PM", "06/11/2019", "Cecilia"},
//                {"Jake", "Perm", "797-797-7979", "4:40 PM", "06/11/2019", "Cecilia"}
        };

        String[] columnNames = {"Name", "Service", "Phone Number", "Time", "Date", "Stylist"};

        appointmentTable = new JTable(setUpAppointmentTableValues(appointments), columnNames);
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

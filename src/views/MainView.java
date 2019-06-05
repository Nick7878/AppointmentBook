package views;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel contentPanel;
    private JTable appointmentTable;


    public MainView() {
        this.contentPanel = new JPanel(new FlowLayout());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setUpAppointmentTable();
                drawWindow();
                addComponentsToFrame();
            }
        });
    }

    private void addComponentsToFrame() {
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
    private void setUpAppointmentTable() {
        String[][] placeholderData = {
                {"Nick", "Cut", "787-787-7878", "3:40 PM", "06/11/2019", "Cecilia"},
                {"Jake", "Perm", "797-797-7979", "4:40 PM", "06/11/2019", "Cecilia"}
        };

        String[] columnNames = {"Name", "Service", "Phone Number", "Time", "Date", "Stylist"};

        appointmentTable = new JTable(placeholderData, columnNames);
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
}

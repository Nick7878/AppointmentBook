package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class AbstractAddEditView extends JFrame {
    //JPanels
    private JPanel mainContentPane;
    private JPanel labelAndTextFieldContentPane;
    private JPanel buttonContentPane;
    //Layouts
    private GroupLayout layout;
    //JLabels
    private JLabel nameLabel;
    private JLabel serviceLabel;
    private JLabel phoneNumberLabel;
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel stylistLabel;
    //JTextFields
    private JTextField nameTextField;
    private JTextField serviceTextField;
    private JTextField phoneNumberTextField;
    private JTextField timeTextField;
    private JTextField dateTextField;
    private JTextField stylistTextField;
    //JButtons
    private JButton cancelButton;

    public AbstractAddEditView() {

    }

    public void buildView() {
        initializeComponents();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                drawWindow();
                addComponentsToPanels();
            }
        });
    }

    public void initializeComponents() {
        this.mainContentPane = new JPanel();
        this.labelAndTextFieldContentPane = new JPanel();
        this.buttonContentPane = new JPanel();
        this.mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.Y_AXIS));
        this.layout = new GroupLayout(this.labelAndTextFieldContentPane);
        this.nameLabel = new JLabel("Name: ", JLabel.TRAILING);
        this.serviceLabel = new JLabel("Service: ", JLabel.TRAILING);
        this.phoneNumberLabel = new JLabel("Phone Number: ", JLabel.TRAILING);
        this.timeLabel = new JLabel("Time: ", JLabel.TRAILING);
        this.dateLabel = new JLabel("Date: ", JLabel.TRAILING);
        this.stylistLabel = new JLabel("Stylist: ", JLabel.TRAILING);
        this.nameTextField = new JTextField(10);
        this.serviceTextField = new JTextField(10);
        this.phoneNumberTextField = new JTextField(10);
        this.timeTextField = new JTextField(10);
        this.dateTextField = new JTextField(10);
        this.stylistTextField = new JTextField(10);
        this.cancelButton = new JButton("Cancel");
    }

    public void addComponentsToPanels() {
        this.labelAndTextFieldContentPane.setLayout(this.layout);
        this.layout.setAutoCreateGaps(true);
        this.layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup horizontalGroup = this.layout.createSequentialGroup();

        horizontalGroup.addGroup(this.layout.createParallelGroup().addComponent(this.nameLabel).addComponent(this.serviceLabel)
                .addComponent(this.phoneNumberLabel).addComponent(this.timeLabel).addComponent(this.dateLabel).addComponent(this.stylistLabel));
        horizontalGroup.addGroup(this.layout.createParallelGroup().addComponent(this.nameTextField).addComponent(this.serviceTextField)
                .addComponent(this.phoneNumberTextField).addComponent(this.timeTextField).addComponent(this.dateTextField).addComponent(this.stylistTextField));
        this.layout.setHorizontalGroup(horizontalGroup);

        GroupLayout.SequentialGroup verticalGroup = this.layout.createSequentialGroup();

        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.nameLabel).addComponent(this.nameTextField));
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.serviceLabel).addComponent(this.serviceTextField));
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.phoneNumberLabel).addComponent(this.phoneNumberTextField));
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.timeLabel).addComponent(this.timeTextField));
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.dateLabel).addComponent(this.dateTextField));
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.stylistLabel).addComponent(this.stylistTextField));

        layout.setVerticalGroup(verticalGroup);

        this.buttonContentPane.add(this.cancelButton);

        this.mainContentPane.add(this.labelAndTextFieldContentPane);
        this.mainContentPane.add(this.buttonContentPane);
    }

    public abstract void drawWindow();

    public String getNameInput() {
        return nameTextField.getText();
    }

    public String getServiceInput() {
        return serviceTextField.getText();
    }

    public String getPhoneNumberInput() {
        return phoneNumberTextField.getText();
    }

    public String getTimeInput() {
        return timeTextField.getText();
    }

    public String getDateInput() {
        return dateTextField.getText();
    }

    public String getStylistInput() {
        return stylistTextField.getText();
    }

    public void setNameInput(String name) {
        nameTextField.setText(name);
    }

    public void setServiceInput(String service) {
        serviceTextField.setText(service);
    }

    public void setPhoneNumberInput(String phoneNumber) {
        phoneNumberTextField.setText(phoneNumber);
    }

    public void setTimeInput(String time) {
        timeTextField.setText(time);
    }

    public void setDateInput(String date) {
        dateTextField.setText(date);
    }

    public void setStylistInput(String stylist) {
        stylistTextField.setText(stylist);
    }

    public void addCancelButtonListener(ActionListener listenerForCancelButton) {
        this.cancelButton.addActionListener(listenerForCancelButton);
    }

    public JPanel getMainContentPane() {
        return this.mainContentPane;
    }

    public JPanel getButtonContentPane() {
        return this.buttonContentPane;
    }

}

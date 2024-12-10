package ui;

import Main.Models.Vehicle;
import Main.dao.VehicleDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {

    private JTextField typeField, modelField, licensePlateField;
    private JCheckBox availableCheckBox;
    private JButton addButton;

    public AdminPanel() {
        setTitle("Admin Panel - Add Vehicle");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        // Vehicle Type Field
        JLabel typeLabel = new JLabel("Vehicle Type:");
        typeLabel.setBounds(20, 30, 100, 25);
        panel.add(typeLabel);

        typeField = new JTextField();
        typeField.setBounds(130, 30, 200, 25);
        panel.add(typeField);

        // Model Field
        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setBounds(20, 70, 100, 25);
        panel.add(modelLabel);

        modelField = new JTextField();
        modelField.setBounds(130, 70, 200, 25);
        panel.add(modelField);

        // License Plate Field
        JLabel licensePlateLabel = new JLabel("License Plate:");
        licensePlateLabel.setBounds(20, 110, 100, 25);
        panel.add(licensePlateLabel);

        licensePlateField = new JTextField();
        licensePlateField.setBounds(130, 110, 200, 25);
        panel.add(licensePlateField);

        // Availability Checkbox
        JLabel availableLabel = new JLabel("Available:");
        availableLabel.setBounds(20, 150, 100, 25);
        panel.add(availableLabel);

        availableCheckBox = new JCheckBox();
        availableCheckBox.setBounds(130, 150, 200, 25);
        panel.add(availableCheckBox);

        // Add Vehicle Button
        addButton = new JButton("Add Vehicle");
        addButton.setBounds(130, 190, 120, 30);
        panel.add(addButton);

        // Action listener for Add Vehicle button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVehicle();
            }
        });
    }

    private void addVehicle() {
        // Get input from fields
        String vehicleType = typeField.getText();
        String vehicleModel = modelField.getText();
        String licensePlate = licensePlateField.getText();
        boolean isAvailable = availableCheckBox.isSelected();

        // Validate input
        if (vehicleType.isEmpty() || vehicleModel.isEmpty() || licensePlate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new vehicle object
        Vehicle vehicle = new Vehicle(0, vehicleType, vehicleModel, licensePlate, isAvailable);

        // Use VehicleDAO to add the vehicle to the database
        VehicleDAO vehicleDAO = new VehicleDAO();
        boolean success = vehicleDAO.addVehicle(vehicle);

        // Show success or failure message
        if (success) {
            JOptionPane.showMessageDialog(this, "Vehicle added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add vehicle.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        // Clear all fields after successful addition
        typeField.setText("");
        modelField.setText("");
        licensePlateField.setText("");
        availableCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }
}

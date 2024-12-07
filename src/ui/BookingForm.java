package ui;

import javax.swing.*;

public class BookingForm {
    private JFrame frame;
    private JComboBox<String> vehicleComboBox;
    private JButton bookButton;

    public BookingForm() {
        frame = new JFrame("Book a Vehicle");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        // Dropdown for selecting a vehicle
        String[] vehicles = {"Car 1", "Car 2", "Car 3"}; // Replace with actual vehicle data
        vehicleComboBox = new JComboBox<>(vehicles);
        panel.add(vehicleComboBox);

        // Book button
        bookButton = new JButton("Book");
        bookButton.addActionListener(e -> bookVehicle());
        panel.add(bookButton);
    }

    private void bookVehicle() {
        String selectedVehicle = (String) vehicleComboBox.getSelectedItem();
        JOptionPane.showMessageDialog(frame, "Booking " + selectedVehicle + "...");
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookingForm bookingForm = new BookingForm();
            bookingForm.showWindow();
        });
    }
}

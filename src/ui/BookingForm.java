package ui;

import Main.Models.User;
import Main.Models.Vehicle;
import Main.Models.Booking;
import Main.dao.VehicleDAO;
import Main.dao.BookingDAO;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class BookingForm {
    private JFrame frame;
    private JComboBox<String> vehicleComboBox;
    private JButton bookButton;
    private User loggedInUser;
    private VehicleDAO vehicleDAO;
    private BookingDAO bookingDAO;
    private List<Vehicle> vehicleList;

    public BookingForm(User user, VehicleDAO vehicleDAO, BookingDAO bookingDAO) {
        this.loggedInUser = user;
        this.vehicleDAO = vehicleDAO;
        this.bookingDAO = bookingDAO;
        initialize();  // Ensure the frame is initialized in the constructor
    }

    private void initialize() {
        frame = new JFrame("Book a Vehicle");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Fetch vehicles from the database
        vehicleList = vehicleDAO.getAllVehicles();

        // Create the dropdown with vehicle details
        vehicleComboBox = new JComboBox<>();
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.isAvailable()) {
                vehicleComboBox.addItem(vehicle.getVehicleType() + " - " + vehicle.getVehicleModel() + " (" + vehicle.getLicensePlate() + ")");
            }
        }

        bookButton = new JButton("Book");
        bookButton.addActionListener(e -> bookVehicle());

        frame.add(new JLabel("Select a Vehicle:"));
        frame.add(vehicleComboBox);
        frame.add(bookButton);
    }

    private void bookVehicle() {
        int selectedIndex = vehicleComboBox.getSelectedIndex();
        if (selectedIndex >= 0) {
            Vehicle selectedVehicle = vehicleList.get(selectedIndex);

            // Create a new booking
            Booking booking = new Booking(0, loggedInUser.getId(), selectedVehicle.getId(), new Date());

            // Save the booking to the database
            bookingDAO.addBooking(booking);

            JOptionPane.showMessageDialog(frame, "Booking successful for vehicle: "
                    + selectedVehicle.getVehicleType() + " - " + selectedVehicle.getVehicleModel());

            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a vehicle.");
        }
    }

    public void showWindow() {
        frame.setVisible(true); // Ensure frame is visible
    }
}

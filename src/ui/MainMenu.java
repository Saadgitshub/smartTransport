package ui;

import Main.Models.User;
import Main.dao.VehicleDAO;
import Main.dao.BookingDAO;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    private JFrame frame;
    private JButton bookButton;
    private JButton profileButton;
    private User loggedInUser;
    private VehicleDAO vehicleDAO;
    private BookingDAO bookingDAO;

    public MainMenu(User user, VehicleDAO vehicleDAO, BookingDAO bookingDAO) {
        this.loggedInUser = user;
        this.vehicleDAO = vehicleDAO;
        this.bookingDAO = bookingDAO;

        // Initialize frame here
        frame = new JFrame("Main Menu - Vehicle Booking System");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window

        // Initialize buttons
        bookButton = new JButton("Book a Vehicle");
        profileButton = new JButton("My Profile");

        initialize();
    }

    public MainMenu(User user) {

    }

    private void initialize() {
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Button to book a vehicle
        bookButton.addActionListener(e -> {
            new BookingForm(loggedInUser, vehicleDAO, bookingDAO).showWindow(); // Pass all necessary objects
            frame.dispose(); // Dispose the current window after opening the next one
        });
        panel.add(bookButton);

        // Button to view the user profile
        profileButton.addActionListener(e -> {
            new UserProfileForm(loggedInUser).showWindow();
            frame.dispose(); // Dispose the current window after opening the next one
        });
        panel.add(profileButton);
    }

    public void showWindow() {
        frame.setVisible(true); // Ensure the frame is visible when called
    }
}

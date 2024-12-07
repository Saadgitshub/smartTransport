package ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainMenu {
    private JFrame frame;
    private JButton bookButton;
    private JButton profileButton;

    public MainMenu() {
        frame = new JFrame("Main Menu - Vehicle Booking System");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        // Button to book a vehicle
        bookButton = new JButton("Book a Vehicle");
        bookButton.addActionListener(e -> showBookingForm());
        panel.add(bookButton);

        // Button to view or edit the user profile
        profileButton = new JButton("My Profile");
        profileButton.addActionListener(e -> showUserProfileForm());
        panel.add(profileButton);
    }

    // Show the booking form (BookingForm class)
    private void showBookingForm() {
        frame.setVisible(false); // Close the main menu
        BookingForm bookingForm = new BookingForm(); // Create the booking form
        bookingForm.showWindow(); // Show the booking form
    }

    // Show the user profile form (UserProfileForm class)
    private void showUserProfileForm() {
        frame.setVisible(false); // Close the main menu
        UserProfileForm profileForm = new UserProfileForm(); // Create the profile form
        profileForm.showWindow(); // Show the profile form
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.showWindow();
        });
    }
}

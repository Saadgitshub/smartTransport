package ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginForm {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        frame = new JFrame("Login - Vehicle Booking System");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(null); // Absolute layout for custom positioning

        // Username label and text field
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 20, 80, 25);
        panel.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        // Password label and text field
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 50, 80, 25);
        panel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        panel.add(loginButton);

        // Action listener for the login button
        loginButton.addActionListener(e -> authenticateUser());
    }

    private void authenticateUser() {
        // Simple username/password check
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();

        // Here, you should add a real authentication check
        if ("Throw".equals(username) && "123456".equals(new String(password))) {
            JOptionPane.showMessageDialog(frame, "Login successful!");
            // After successful login, show the Main Menu
            showMainMenu();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password.");
        }
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    // This method would be used to navigate to the main menu
    private void showMainMenu() {
        frame.setVisible(false); // Close the login form
        MainMenu mainMenu = new MainMenu(); // Create the main menu
        mainMenu.showWindow(); // Show the main menu
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            loginForm.showWindow();
        });
    }
}

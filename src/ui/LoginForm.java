package ui;

import Main.dao.BookingDAO;
import Main.dao.UserDAO;
import Main.Models.User;
import Main.dao.VehicleDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserDAO userDAO;

    public LoginForm() {
        // Initialize DAO here
        this.userDAO = new UserDAO();

        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        // Username field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 30, 80, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 30, 160, 25);
        panel.add(usernameField);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 70, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 70, 160, 25);
        panel.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 100, 30);
        panel.add(loginButton);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 150, 100, 30);
        panel.add(backButton);

        // Action listener for back button
        backButton.addActionListener(e -> openWelcomeForm());

        // Action listener for login button
        loginButton.addActionListener(e -> loginUser());
    }

    private void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Authenticate user using DAO
        User user = userDAO.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Successful login, navigate to the main menu
            JOptionPane.showMessageDialog(this, "Login successful!");
            openMainMenu(user);  // Pass the authenticated user to the MainMenu
            this.dispose();
        } else {
            // Failed login attempt
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    private void openMainMenu(User user) {
        // Passing the logged-in user to MainMenu
        MainMenu mainMenu = new MainMenu(user, new VehicleDAO(), new BookingDAO());
        mainMenu.showWindow();  // Show the main menu
    }

    private void openWelcomeForm() {
        new WelcomeForm().setVisible(true);  // Open WelcomeForm
        this.dispose();  // Close LoginForm
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}

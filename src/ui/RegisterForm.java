package ui;

import Main.Controllers.UserController;
import Main.Models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registerButton;

    private UserController userController;

    public RegisterForm() {
        userController = new UserController();  // Initialize the controller

        setTitle("Register Form");
        setSize(300, 250);
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

        // Email field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 70, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 70, 160, 25);
        panel.add(emailField);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 110, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 110, 160, 25);
        panel.add(passwordField);

        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 150, 100, 30);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Collect data from the form
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Create a User object
        User newUser = new User(0, username, email, password);

        // Add user to the database via the controller
        boolean success = userController.addUser(newUser);

        // Show success or failure message
        if (success) {
            JOptionPane.showMessageDialog(this, "User registered successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to register user.");
        }
    }

    public static void main(String[] args) {
        // Launch the RegisterForm UI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }
}

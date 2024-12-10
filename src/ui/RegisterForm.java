package ui;

import Main.Controllers.UserController;
import Main.Models.User;
import Main.dao.UserDAO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField phoneNumberField;  // Added phone number field
    private JButton registerButton;
    private JButton backButton; // Added Back button

    private UserController userController;

    public RegisterForm() {
        userController = new UserController();  // Initialize the controller

        setTitle("Register Form");
        setSize(300, 300);  // Increased the size to accommodate the new field
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

        // Phone Number field
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(20, 150, 100, 25);
        panel.add(phoneLabel);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(100, 150, 160, 25);
        panel.add(phoneNumberField);

        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 190, 100, 30);
        panel.add(registerButton);

        // Back button to return to the WelcomeForm
        backButton = new JButton("Back");
        backButton.setBounds(100, 230, 100, 30);  // Adjusted position for the Back button
        panel.add(backButton);

        // Action listener for the Register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        // Action listener for the Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWelcomeForm();
            }
        });
    }

    private void registerUser() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String phoneNumber = phoneNumberField.getText();

        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Phone Number: " + phoneNumber);

        User newUser = new User(0, username, password, email, phoneNumber);

        try {
            UserDAO.createUser(newUser);
            JOptionPane.showMessageDialog(this, "User registered successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to register user.");
            e.printStackTrace();
        }
    }

    private void openWelcomeForm() {
        // Close the current RegisterForm and show the WelcomeForm
        new WelcomeForm().setVisible(true);
        this.dispose();  // Close RegisterForm
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

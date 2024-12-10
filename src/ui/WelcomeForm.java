package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeForm extends JFrame {

    public WelcomeForm() {
        setTitle("Welcome to Our Booking Service");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to our booking service!");
        welcomeLabel.setBounds(50, 30, 200, 25);
        panel.add(welcomeLabel);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 70, 100, 30);
        panel.add(loginButton);

        // Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 110, 100, 30);
        panel.add(registerButton);

        // Action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLoginForm();
            }
        });

        // Action listener for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegisterForm();
            }
        });
    }

    private void openLoginForm() {
        new LoginForm().setVisible(true); // Open LoginForm
        this.dispose(); // Close WelcomeForm
    }

    private void openRegisterForm() {
        new RegisterForm().setVisible(true); // Open RegisterForm
        this.dispose(); // Close WelcomeForm
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WelcomeForm().setVisible(true);
            }
        });
    }
}

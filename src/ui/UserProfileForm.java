package ui;

import javax.swing.*;

public class UserProfileForm {
    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;
    private JButton saveButton;

    public UserProfileForm() {
        frame = new JFrame("User Profile");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        panel.add(nameLabel);
        panel.add(nameField);

        // Email field
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        panel.add(emailLabel);
        panel.add(emailField);

        // Save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveProfile());
        panel.add(saveButton);
    }

    private void saveProfile() {
        JOptionPane.showMessageDialog(frame, "Profile saved!");
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserProfileForm profileForm = new UserProfileForm();
            profileForm.showWindow();
        });
    }
}

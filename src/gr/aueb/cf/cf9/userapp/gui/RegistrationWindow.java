package gr.aueb.cf.cf9.userapp.gui;

import gr.aueb.cf.cf9.userapp.dao.IUserDAO;
import gr.aueb.cf.cf9.userapp.dao.UserDAOImpl;
import gr.aueb.cf.cf9.userapp.exception.UserAlreadyExistsException;
import gr.aueb.cf.cf9.userapp.exception.WeakPasswordException;
import gr.aueb.cf.cf9.userapp.model.User;
import gr.aueb.cf.cf9.userapp.service.AuthServiceImpl;
import gr.aueb.cf.cf9.userapp.service.IAuthService;

import javax.swing.*;
import java.awt.*;

public class RegistrationWindow extends JFrame {

    private final JTextField usernameField;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;

    private final IAuthService authService;

    public RegistrationWindow() {
        IUserDAO userDAO = new UserDAOImpl();
        this.authService = new AuthServiceImpl(userDAO);

        setTitle("User Application - Register");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Style.SECONDARY_COLOR);

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Style.PRIMARY_COLOR);
        headerPanel.setBorder(Style.PADDING_LARGE);
        JLabel headerLabel = new JLabel("Create a New Account");
        headerLabel.setFont(Style.FONT_HEADER);
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Style.SECONDARY_COLOR);
        formPanel.setBorder(Style.PADDING_LARGE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username, Email, Password, Confirm Password fields...
        usernameField = new JTextField(15);
        emailField = new JTextField(15);
        passwordField = new JPasswordField(15);
        confirmPasswordField = new JPasswordField(15);
        
        setupFormField(formPanel, gbc, "Username:", usernameField, 0);
        setupFormField(formPanel, gbc, "Email:", emailField, 1);
        setupFormField(formPanel, gbc, "Password:", passwordField, 2);
        setupFormField(formPanel, gbc, "Confirm Password:", confirmPasswordField, 3);

        add(formPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        buttonPanel.setBackground(Style.SECONDARY_COLOR);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(Style.FONT_BUTTON);
        registerButton.setBackground(Style.SUCCESS_COLOR);
        registerButton.setForeground(Color.WHITE);
        buttonPanel.add(registerButton);

        JButton backToLoginButton = new JButton("Back to Login");
        backToLoginButton.setFont(Style.FONT_BUTTON);
        backToLoginButton.setBackground(Style.PRIMARY_COLOR);
        backToLoginButton.setForeground(Color.WHITE);
        buttonPanel.add(backToLoginButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        registerButton.addActionListener(e -> handleRegistration());
        backToLoginButton.addActionListener(e -> {
            new LoginWindow().setVisible(true);
            dispose();
        });
    }

    private void setupFormField(JPanel panel, GridBagConstraints gbc, String labelText, JComponent component, int yPos) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        JLabel label = new JLabel(labelText);
        label.setFont(Style.FONT_GENERAL);
        panel.add(label, gbc);

        gbc.gridx = 1;
        component.setFont(Style.FONT_GENERAL);
        panel.add(component, gbc);
    }

    private void handleRegistration() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            User user = new User(username, password, email);
            authService.register(user);
            JOptionPane.showMessageDialog(this, "Registration successful! You can now log in.", "Success", JOptionPane.INFORMATION_MESSAGE);
            new LoginWindow().setVisible(true);
            dispose();
        } catch (WeakPasswordException | UserAlreadyExistsException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

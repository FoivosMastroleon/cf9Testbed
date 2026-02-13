package gr.aueb.cf.cf9.userapp.gui;

import gr.aueb.cf.cf9.userapp.dao.IUserDAO;
import gr.aueb.cf.cf9.userapp.dao.UserDAOImpl;
import gr.aueb.cf.cf9.userapp.exception.InvalidCredentialsException;
import gr.aueb.cf.cf9.userapp.model.User;
import gr.aueb.cf.cf9.userapp.model.UserCredentials;
import gr.aueb.cf.cf9.userapp.service.AuthServiceImpl;
import gr.aueb.cf.cf9.userapp.service.IAuthService;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final IAuthService authService;

    public LoginWindow() {
        IUserDAO userDAO = new UserDAOImpl();
        this.authService = new AuthServiceImpl(userDAO);

        setTitle("User Application - Login");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Style.SECONDARY_COLOR);

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Style.PRIMARY_COLOR);
        headerPanel.setBorder(Style.PADDING_LARGE);
        JLabel headerLabel = new JLabel("Welcome Back!");
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

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        setupFormField(formPanel, gbc, "Username:", usernameField, 0);
        setupFormField(formPanel, gbc, "Password:", passwordField, 1);

        add(formPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        buttonPanel.setBackground(Style.SECONDARY_COLOR);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(Style.FONT_BUTTON);
        loginButton.setBackground(Style.PRIMARY_COLOR);
        loginButton.setForeground(Color.WHITE);
        buttonPanel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(Style.FONT_BUTTON);
        registerButton.setBackground(Style.SUCCESS_COLOR);
        registerButton.setForeground(Color.WHITE);
        buttonPanel.add(registerButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> {
            new RegistrationWindow().setVisible(true);
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

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        UserCredentials credentials = new UserCredentials(username, password);

        try {
            User user = authService.login(credentials);
            new MainDashboard(user).setVisible(true);
            dispose();
        } catch (InvalidCredentialsException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Login Failed", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

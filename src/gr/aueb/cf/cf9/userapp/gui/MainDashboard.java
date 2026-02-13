package gr.aueb.cf.cf9.userapp.gui;

import gr.aueb.cf.cf9.userapp.dao.IUserDAO;
import gr.aueb.cf.cf9.userapp.dao.UserDAOImpl;
import gr.aueb.cf.cf9.userapp.model.User;

import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {

    private User loggedInUser;
    private final IUserDAO userDAO = new UserDAOImpl();

    public MainDashboard(User user) {
        this.loggedInUser = user;

        setTitle("User Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Style.SECONDARY_COLOR);

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Style.PRIMARY_COLOR);
        headerPanel.setBorder(Style.PADDING_LARGE);
        JLabel welcomeLabel = new JLabel("Welcome, " + loggedInUser.username() + "!");
        welcomeLabel.setFont(Style.FONT_HEADER);
        welcomeLabel.setForeground(Color.WHITE);
        headerPanel.add(welcomeLabel, BorderLayout.WEST);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(Style.FONT_BUTTON);
        logoutButton.setBackground(Style.ERROR_COLOR);
        logoutButton.setForeground(Color.WHITE);
        headerPanel.add(logoutButton, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // Main Content
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Style.SECONDARY_COLOR);
        mainPanel.setBorder(Style.PADDING_LARGE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton viewProfileButton = new JButton("View Profile");
        viewProfileButton.setFont(Style.FONT_BUTTON);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(viewProfileButton, gbc);

        JButton changeEmailButton = new JButton("Change Email");
        changeEmailButton.setFont(Style.FONT_BUTTON);
        gbc.gridy = 1;
        mainPanel.add(changeEmailButton, gbc);

        JButton viewStatsButton = new JButton("Usage Statistics");
        viewStatsButton.setFont(Style.FONT_BUTTON);
        gbc.gridy = 2;
        mainPanel.add(viewStatsButton, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Action Listeners
        logoutButton.addActionListener(e -> {
            new LoginWindow().setVisible(true);
            dispose();
        });

        viewProfileButton.addActionListener(e -> viewProfile());
        changeEmailButton.addActionListener(e -> changeEmail());
        viewStatsButton.addActionListener(e -> viewStats());
    }

    private void viewProfile() {
        String profileInfo = "Username: " + loggedInUser.username() + "\n" +
                             "Email: " + loggedInUser.email();
        JOptionPane.showMessageDialog(this, profileInfo, "My Profile", JOptionPane.INFORMATION_MESSAGE);
    }

    private void changeEmail() {
        String newEmail = JOptionPane.showInputDialog(this, "Enter new email:", "Change Email", JOptionPane.PLAIN_MESSAGE);
        if (newEmail != null && !newEmail.trim().isEmpty()) {
            User updatedUser = new User(loggedInUser.username(), loggedInUser.password(), newEmail);
            userDAO.update(updatedUser);
            JOptionPane.showMessageDialog(this, "Email updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            // Refresh the dashboard with the updated user information
            new MainDashboard(updatedUser).setVisible(true);
            dispose();
        }
    }

    private void viewStats() {
        // Dummy statistics
        String stats = "Logins Today: 5\n" +
                       "Total Logins: 142\n" +
                       "Last Login: Today";
        JOptionPane.showMessageDialog(this, stats, "Usage Statistics", JOptionPane.INFORMATION_MESSAGE);
    }
}

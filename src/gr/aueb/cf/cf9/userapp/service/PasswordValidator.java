package gr.aueb.cf.cf9.userapp.service;

import gr.aueb.cf.cf9.userapp.exception.WeakPasswordException;

public class PasswordValidator {

    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-[]{}|;:,.<>?";


    public static void validate(String password) throws WeakPasswordException {
        if (password == null || password.isEmpty()) {
            throw new WeakPasswordException("Password cannot be null or empty");
        }

        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            throw new WeakPasswordException("Password must be between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters long");

        }

        if (!hasUpperCase(password)) {
            throw new WeakPasswordException("Password must contain at least one uppercase letter");
        }
        if (!hasLowerCase(password)) {
            throw new WeakPasswordException("Password must contain at least one lowercase letter");
        }
        if (!hasDigit(password)) {
            throw new WeakPasswordException("Password must contain at lease one digit");
        }
        if (!hasSpecialChars(password)) {
            throw new WeakPasswordException("Password must contain at least one special character");
        }

    }

    private static boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }

        }
        return false;
    }

    private static boolean hasSpecialChars(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARS.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static String getPasswordRequirements() {
        return """
                Strong Password Criteria:
                - At least 8 characters
                - At least 1 uppercase letter (A-Z)
                - At least 1 lowercase letter (a-z)
                - At least 1 digit (0-9)
                - At least 1 special character (!@#$%^&*...)
                """;
    }
}
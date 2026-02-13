package gr.aueb.cf.cf9.userapp.model;

import java.io.Serializable;

public record User(
        String username,
        String password,
        String email
) implements Serializable {
    private static final long serialVersionUID = 1L;

    public User {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }

    public User withoutPassword() {
        return new User(username, "***HIDDEN***", email);
    }
}

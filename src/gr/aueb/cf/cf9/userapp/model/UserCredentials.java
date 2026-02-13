package gr.aueb.cf.cf9.userapp.model;

import java.io.Serializable;

public record UserCredentials(
        String username,
        String password
) implements Serializable {
    private static final long serialVersionUID = 1L;

    public UserCredentials {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
    }
}

package gr.aueb.cf.cf9.userapp.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String username) {
        super("The user '" + username + "' already exists");
    }
}

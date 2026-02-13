package gr.aueb.cf.cf9.userapp.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String username) {
        super("Account with username '" + username + "' not found");
    }
}

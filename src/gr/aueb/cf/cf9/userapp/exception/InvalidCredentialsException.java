package gr.aueb.cf.cf9.userapp.exception;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException() {
        super("Invalid credentials: username or password is incorrect! \n Please try again.");
    }
}

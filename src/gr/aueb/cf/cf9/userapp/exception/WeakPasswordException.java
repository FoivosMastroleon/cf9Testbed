package gr.aueb.cf.cf9.userapp.exception;

public class WeakPasswordException extends Exception {
    private final String reason;

    public WeakPasswordException(String reason) {
        super ("Weak password bro: " + reason );
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}

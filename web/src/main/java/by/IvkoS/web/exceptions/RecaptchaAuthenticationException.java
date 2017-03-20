package by.IvkoS.web.exceptions;

public class RecaptchaAuthenticationException extends RuntimeException {
    public RecaptchaAuthenticationException(String message) {
        super(message);
    }
}

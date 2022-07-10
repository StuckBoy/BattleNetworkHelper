package exceptions;

public class UnsupportedGameException extends Exception {

    private String message;

    public UnsupportedGameException(String s) {
        message = s;
    }

    public String getMessage() {
        return message;
    }
}
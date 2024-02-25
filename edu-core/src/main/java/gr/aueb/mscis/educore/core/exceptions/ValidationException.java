package gr.aueb.mscis.educore.core.exceptions;

public class ValidationException extends RuntimeException {
    String message;

    public ValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

}

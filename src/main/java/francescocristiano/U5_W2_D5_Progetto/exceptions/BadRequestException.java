package francescocristiano.U5_W2_D5_Progetto.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

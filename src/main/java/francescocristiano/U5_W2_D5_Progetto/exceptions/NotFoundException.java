package francescocristiano.U5_W2_D5_Progetto.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {

    public NotFoundException(UUID id) {
        super("Entity with id " + id + " not found");
    }
}

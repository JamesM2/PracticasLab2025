package excepciones;

// Excepción personalizada para claves duplicadas
public class DuplicatedItemException extends RuntimeException {
    public DuplicatedItemException(String message) {
        super(message);
    }
}

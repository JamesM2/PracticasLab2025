package exceptions;

// Excepción personalizada para elementos duplicados
public class ItemDuplicated extends Exception {
    public ItemDuplicated(String message) {
        super(message);
    }
}

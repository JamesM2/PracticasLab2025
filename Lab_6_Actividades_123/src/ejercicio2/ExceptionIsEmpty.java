package ejercicio2;

// Excepción personalizada para cuando se intenta acceder a una cola vacía
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String message) {
        super(message);
    }
}

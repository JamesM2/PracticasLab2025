package ejercicio2;

// Excepci�n personalizada para cuando se intenta acceder a una cola vac�a
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String message) {
        super(message);
    }
}

package actividad1;

// Clase para lanzar una excepción cuando se intenta operar con una pila vacía
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String msg) {
        super(msg); // Envía el mensaje al constructor de la clase padre
    }
}

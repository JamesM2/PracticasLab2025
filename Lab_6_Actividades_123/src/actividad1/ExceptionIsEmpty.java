package actividad1;

// Clase para lanzar una excepci�n cuando se intenta operar con una pila vac�a
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String msg) {
        super(msg); // Env�a el mensaje al constructor de la clase padre
    }
}

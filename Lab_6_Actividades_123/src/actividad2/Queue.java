package actividad2;

import actividad1.ExceptionIsEmpty; // Importamos la excepci�n ya definida en el paquete anterior

public interface Queue<E> {
    void enqueue(E x);                          // Inserta un elemento al final de la cola
    E dequeue() throws ExceptionIsEmpty;        // Elimina y retorna el primer elemento de la cola
    E front() throws ExceptionIsEmpty;          // Retorna el primer elemento sin eliminarlo
    E back() throws ExceptionIsEmpty;           // Retorna el �ltimo elemento sin eliminarlo
    boolean isEmpty();                          // Verifica si la cola est� vac�a
}

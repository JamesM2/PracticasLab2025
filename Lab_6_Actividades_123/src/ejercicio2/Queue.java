package ejercicio2;

// Interfaz gen�rica de una cola
public interface Queue<E> {
    void enqueue(E x); // Inserta un elemento al final
    E dequeue() throws ExceptionIsEmpty; // Elimina el elemento del frente
    E front() throws ExceptionIsEmpty; // Retorna el elemento del frente
    E back() throws ExceptionIsEmpty; // Retorna el �ltimo elemento
    boolean isEmpty(); // Verifica si la cola est� vac�a
}

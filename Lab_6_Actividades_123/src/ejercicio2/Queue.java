package ejercicio2;

// Interfaz genérica de una cola
public interface Queue<E> {
    void enqueue(E x); // Inserta un elemento al final
    E dequeue() throws ExceptionIsEmpty; // Elimina el elemento del frente
    E front() throws ExceptionIsEmpty; // Retorna el elemento del frente
    E back() throws ExceptionIsEmpty; // Retorna el último elemento
    boolean isEmpty(); // Verifica si la cola está vacía
}

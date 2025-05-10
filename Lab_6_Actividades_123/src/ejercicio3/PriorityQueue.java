package ejercicio3;

// Interface que define las operaciones básicas de una cola de prioridad
public interface PriorityQueue<E> {
    void enqueue(E x, int priority);           // Inserta un elemento con su prioridad
    E dequeue() throws ExceptionIsEmpty;       // Elimina el elemento con mayor prioridad
    E front() throws ExceptionIsEmpty;         // Retorna el primero con mayor prioridad
    E back() throws ExceptionIsEmpty;          // Retorna el último con mayor prioridad
    boolean isEmpty();                         // Verifica si la cola de prioridad está vacía
}

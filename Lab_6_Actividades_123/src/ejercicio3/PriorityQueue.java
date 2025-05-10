package ejercicio3;

// Interface que define las operaciones b�sicas de una cola de prioridad
public interface PriorityQueue<E> {
    void enqueue(E x, int priority);           // Inserta un elemento con su prioridad
    E dequeue() throws ExceptionIsEmpty;       // Elimina el elemento con mayor prioridad
    E front() throws ExceptionIsEmpty;         // Retorna el primero con mayor prioridad
    E back() throws ExceptionIsEmpty;          // Retorna el �ltimo con mayor prioridad
    boolean isEmpty();                         // Verifica si la cola de prioridad est� vac�a
}

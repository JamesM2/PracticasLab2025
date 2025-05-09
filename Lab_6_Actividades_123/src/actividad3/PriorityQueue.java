package actividad3;

import actividad1.ExceptionIsEmpty;


// Interfaz genérica de cola de prioridad
// E: tipo de dato a almacenar
// N: tipo de la prioridad (debe ser comparable)
public interface PriorityQueue<E, N extends Comparable<N>> {
    void enqueue(E x, N pr);                // Inserta un elemento con su prioridad
    E dequeue() throws ExceptionIsEmpty;    // Elimina y retorna el de mayor prioridad
    E front() throws ExceptionIsEmpty;      // Retorna el elemento al frente
    E back() throws ExceptionIsEmpty;       // Retorna el último elemento
    boolean isEmpty();                      // Verifica si la cola está vacía
}

package actividad3;
import actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    // Clase interna que encapsula un elemento y su prioridad
    class EntryNode {
        E data;        // Elemento
        N priority;    // Prioridad

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }

        public String toString() {
            return "(" + data + ", prioridad=" + priority + ")";
        }
    }

    // Referencias al primer y �ltimo nodo de la lista
    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    // Inserta un nuevo nodo en su posici�n ordenada (de mayor a menor prioridad)
    public void enqueue(E x, N pr) {
        EntryNode nuevo = new EntryNode(x, pr);       // Crea una entrada con dato y prioridad
        Node<EntryNode> nuevoNodo = new Node<>(nuevo); // Crea un nodo contenedor

        // Caso 1: lista vac�a
        if (isEmpty()) {
            first = last = nuevoNodo;
        }
        // Caso 2: el nuevo elemento tiene mayor prioridad que el primero
        else if (pr.compareTo(first.getData().priority) > 0) {
            nuevoNodo.setNext(first);  // Inserta al inicio
            first = nuevoNodo;
        }
        // Caso 3: insertar en posici�n intermedia o al final
        else {
            Node<EntryNode> actual = first;
            Node<EntryNode> anterior = null;

            // Recorre hasta encontrar la posici�n seg�n prioridad
            while (actual != null && pr.compareTo(actual.getData().priority) <= 0) {
                anterior = actual;
                actual = actual.getNext();
            }

            nuevoNodo.setNext(actual);     // Enlaza al siguiente
            anterior.setNext(nuevoNodo);   // Enlaza al anterior

            if (actual == null)            // Si es el nuevo �ltimo
                last = nuevoNodo;
        }
    }

    // Elimina y retorna el primer elemento (el de mayor prioridad)
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("No se puede eliminar de una cola vac�a");

        E dato = first.getData().data;   // Obtiene el dato del primer nodo
        first = first.getNext();         // Avanza el puntero al siguiente

        if (first == null)
            last = null;                // Si la cola qued� vac�a, actualiza el �ltimo

        return dato;
    }

    // Retorna el �ltimo elemento (el de menor prioridad)
    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vac�a");

        return last.getData().data;
    }

    // Retorna el primer elemento (el de mayor prioridad)
    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vac�a");

        return first.getData().data;
    }

    // Verifica si la cola est� vac�a
    public boolean isEmpty() {
        return first == null;
    }

    // Retorna la representaci�n en texto de la cola
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> actual = first;

        while (actual != null) {
            sb.append(actual.getData().toString()).append(" -> ");
            actual = actual.getNext();
        }

        return sb.length() > 0 ? sb.substring(0, sb.length() - 4) : "cola vac�a";
    }
}

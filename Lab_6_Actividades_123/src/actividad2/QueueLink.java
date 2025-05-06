// archivo: actividad2/QueueLink.java
package actividad2;

import actividad1.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;   // Primer nodo de la cola
    private Node<E> last;    // �ltimo nodo de la cola

    public QueueLink() {
        this.first = null;
        this.last = null;
    }


    public void enqueue(E x) {
        Node<E> aux = new Node<>(x); // Se crea un nuevo nodo
        if (isEmpty()) {
            this.first = aux; // Si est� vac�a, el primero es el nuevo nodo
        } else {
            this.last.setNext(aux); // El actual �ltimo apunta al nuevo nodo
        }
        this.last = aux; // El nuevo nodo pasa a ser el �ltimo
    }


    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola est� vac�a.");
        }
        E dato = first.getData();
        first = first.getNext(); // Se avanza el puntero del primero
        if (first == null) {
            last = null; // Si la cola queda vac�a, se actualiza el �ltimo
        }
        return dato;
    }


    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola est� vac�a.");
        }
        return first.getData();
    }


    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola est� vac�a.");
        }
        return last.getData();
    }


    public boolean isEmpty() {
        return first == null; // Verdadero si no hay nodos en la cola
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> actual = first;
        while (actual != null) {
            sb.append(actual.getData());
            if (actual.getNext() != null) {
                sb.append(", ");
            }
            actual = actual.getNext();
        }
        sb.append("]");
        return sb.toString(); // Representa los elementos de frente a fondo
    }
}

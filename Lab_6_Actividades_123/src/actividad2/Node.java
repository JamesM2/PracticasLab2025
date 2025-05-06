// archivo: actividad2/Node.java
package actividad2;

public class Node<E> {
    private E data;            // Dato que almacena el nodo
    private Node<E> next;      // Referencia al siguiente nodo

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

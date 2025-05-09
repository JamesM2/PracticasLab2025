package actividad3;

// Clase genérica para nodos de lista enlazada
public class Node<T> {
    private T data;             // Dato almacenado
    private Node<T> next;       // Referencia al siguiente nodo

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public Node<T> getNext() { return next; }
    public void setNext(Node<T> next) { this.next = next; }
}

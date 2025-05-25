package arboles;

// Clase genérica para representar un nodo del árbol
public class Node<T> {
    public T key;
    public int height;
    public Node<T> left, right;

    public Node(T key) {
        this.key = key;
        this.height = 1;
    }
}

package arboles;

// Clase gen�rica para representar un nodo del �rbol
public class Node<T> {
    public T key;
    public int height;
    public Node<T> left, right;

    public Node(T key) {
        this.key = key;
        this.height = 1;
    }
}

package arboles;

// Árbol binario de búsqueda básico con métodos comunes
public class BSTree<T extends Comparable<T>> {
    public Node<T> root;

    public boolean search(Node<T> node, T key) {
        if (node == null) return false;
        if (key.compareTo(node.key) == 0) return true;
        return key.compareTo(node.key) < 0 ?
                search(node.left, key) :
                search(node.right, key);
    }

    public int height(Node<T> node) {
        return (node == null) ? 0 : node.height;
    }
}

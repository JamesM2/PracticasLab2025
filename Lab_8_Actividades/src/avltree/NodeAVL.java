package avltree;

// Nodo especializado para árbol AVL
public class NodeAVL<E> extends BSTree<E>.Node {

    // Factor de equilibrio
    protected int bf;

    // Constructor del nodo AVL
    public NodeAVL(E data) {
        super(data);
        this.bf = 0;
    }

    // Mostrar el nodo con su factor de equilibrio
    public String toString() {
        return super.toString() + " (bf=" + bf + ")";
    }
}

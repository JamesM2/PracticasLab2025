package avltree;

import exceptions.ItemDuplicated;

// Árbol binario de búsqueda básico
public class BSTree<E extends Comparable<E>> {

    // Nodo interno del árbol
    protected class Node {
        protected E data;
        protected Node left, right;

        // Constructor del nodo
        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Mostrar el contenido del nodo
        public String toString() {
            return data.toString();
        }
    }

    protected Node root;

    // Constructor del árbol
    public BSTree() {
        this.root = null;
    }

    // Método base de inserción, será sobreescrito en AVLTree
    public void insert(E x) throws ItemDuplicated {
    }
}

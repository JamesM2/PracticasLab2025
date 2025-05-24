package avltree;

import exceptions.ItemDuplicated;

// �rbol binario de b�squeda b�sico
public class BSTree<E extends Comparable<E>> {

    // Nodo interno del �rbol
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

    // Constructor del �rbol
    public BSTree() {
        this.root = null;
    }

    // M�todo base de inserci�n, ser� sobreescrito en AVLTree
    public void insert(E x) throws ItemDuplicated {
    }
}

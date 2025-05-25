package arboles;

// Árbol AVL que extiende el árbol binario de búsqueda
public class AVLTree<T extends Comparable<T>> extends BSTree<T> {

    public Node<T> insert(Node<T> node, T key) {
        if (node == null) return new Node<>(key);

        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key);
        else return node;

        updateHeight(node);
        return balance(node);
    }

    public Node<T> delete(Node<T> node, T key) {
        if (node == null) return null;

        if (key.compareTo(node.key) < 0)
            node.left = delete(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node<T> minNode = getMin(node.right);
                node.key = minNode.key;
                node.right = delete(node.right, minNode.key);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        return balance(node);
    }

    private Node<T> getMin(Node<T> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private void updateHeight(Node<T> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int getBalance(Node<T> node) {
        return height(node.left) - height(node.right);
    }

    private Node<T> balance(Node<T> node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.left) < 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1) {
            if (getBalance(node.right) > 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;
        x.right = y;
        y.left = T2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;
        y.left = x;
        x.right = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    // Recorrido preorden (Ejercicio 5)
    public void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Recorrido por niveles BFS (Ejercicio 3 y 4)
    public void printLevelOrder(Node<T> root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
        }
    }

    private void printGivenLevel(Node<T> root, int level) {
        if (root == null) return;
        if (level == 1) System.out.print(root.key + " ");
        else {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
}

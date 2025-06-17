package btree;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    // Inserta una clave al árbol
    public void insert(E key) {
        if (root == null) {
            root = new BNode<>(orden);
            root.keys.set(0, key);
            root.count = 1;
        } else {
            BNode<E> newChild = new BNode<>(orden);
            E upKey = insertRecursive(root, key, newChild);
            if (upKey != null) {
                BNode<E> newRoot = new BNode<>(orden);
                newRoot.keys.set(0, upKey);
                newRoot.childs.set(0, root);
                newRoot.childs.set(1, newChild);
                newRoot.count = 1;
                root = newRoot;
            }
        }
    }

    // Inserción recursiva
    private E insertRecursive(BNode<E> node, E key, BNode<E> newChild) {
        int i = 0;
        while (i < node.count && key.compareTo(node.keys.get(i)) > 0) {
            i++;
        }

        if (i < node.count && key.compareTo(node.keys.get(i)) == 0) {
            return null; // Clave duplicada
        }

        if (node.childs.get(i) == null) {
            for (int j = node.count; j > i; j--) {
                node.keys.set(j, node.keys.get(j - 1));
            }
            node.keys.set(i, key);
            node.count++;
            if (node.count == orden) {
                return split(node, newChild);
            }
            return null;
        } else {
            BNode<E> temp = new BNode<>(orden);
            E upKey = insertRecursive(node.childs.get(i), key, temp);
            if (upKey == null) return null;

            for (int j = node.count; j > i; j--) {
                node.keys.set(j, node.keys.get(j - 1));
                node.childs.set(j + 1, node.childs.get(j));
            }

            node.keys.set(i, upKey);
            node.childs.set(i + 1, temp);
            node.count++;

            if (node.count == orden) {
                return split(node, newChild);
            }

            return null;
        }
    }

    // Divide un nodo y actualiza
    private E split(BNode<E> node, BNode<E> newChild) {
        int mid = orden / 2;
        E upKey = node.keys.get(mid);
        newChild.count = orden - mid - 1;

        for (int i = 0; i < newChild.count; i++) {
            newChild.keys.set(i, node.keys.get(mid + 1 + i));
            newChild.childs.set(i, node.childs.get(mid + 1 + i));
        }
        newChild.childs.set(newChild.count, node.childs.get(orden));
        node.count = mid;

        return upKey;
    }

    // Imprime el árbol en preorden
    public void print() {
        printRecursive(root, "");
    }

    private void printRecursive(BNode<E> node, String prefix) {
        if (node != null) {
            System.out.println(prefix + node);
            for (int i = 0; i <= node.count; i++) {
                printRecursive(node.childs.get(i), prefix + "  ");
            }
        }
    }

    // Busca una clave y muestra su ubicación
    public boolean search(E key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(BNode<E> node, E key) {
        if (node == null) return false;
        int[] pos = new int[1];
        boolean found = node.searchNode(key, pos);
        if (found) {
            System.out.println(key + " se encuentra en el nodo " + node.idNode + " en la posición " + pos[0]);
            return true;
        } else {
            return searchRecursive(node.childs.get(pos[0]), key);
        }
    }
}

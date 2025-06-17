package btree;

import model.RegistroEstudiante;
import java.util.*;

// Árbol B genérico
public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    // Inserta una clave en el árbol
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

    // Inserta recursivamente
    private E insertRecursive(BNode<E> node, E key, BNode<E> newChild) {
        int i = 0;
        while (i < node.count && key.compareTo(node.keys.get(i)) > 0) {
            i++;
        }

        if (i < node.count && key.compareTo(node.keys.get(i)) == 0) {
            return null; // clave duplicada
        }

        if (node.childs.get(i) == null) {
            for (int j = node.count; j > i; j--) {
                node.keys.set(j, node.keys.get(j - 1));
            }
            node.keys.set(i, key);
            node.count++;
            if (node.count == orden) return split(node, newChild);
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
            if (node.count == orden) return split(node, newChild);
            return null;
        }
    }

    // Divide el nodo lleno
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

    // Imprime el árbol
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

    // Busca una clave
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

    // Busca por código y devuelve el nombre
    public String buscarNombre(int codigo) {
        RegistroEstudiante resultado = buscarNombreRecursivo(root, codigo);
        return (resultado != null) ? resultado.getNombre() : "No encontrado";
    }

    // Busca recursivamente por código
    private RegistroEstudiante buscarNombreRecursivo(BNode<E> node, int codigo) {
        if (node == null) return null;
        for (int i = 0; i < node.count; i++) {
            RegistroEstudiante actual = (RegistroEstudiante) node.keys.get(i);
            if (actual.getCodigo() == codigo) return actual;
            if (actual.getCodigo() > codigo) {
                return buscarNombreRecursivo(node.childs.get(i), codigo);
            }
        }
        return buscarNombreRecursivo(node.childs.get(node.count), codigo);
    }
}

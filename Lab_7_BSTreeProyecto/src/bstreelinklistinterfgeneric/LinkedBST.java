package bstreelinklistinterfgeneric;

import bstreeInterface.BinarySearchTree;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    // Nodo interno del BST
    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this(data, null, null);
        }

        Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public LinkedBST() {
        root = null;
    }

    // Método isEmpty
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // Método insert
    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertRec(node.left, data);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, data);
        } else {
            throw new ItemDuplicated("Error: El dato " + data + " ya existe en el BST.");
        }
        return node;
    }

    // Método search
    @Override
    public E search(E data) throws ItemNotFound {
        Node result = searchRec(root, data);
        if (result == null) throw new ItemNotFound("Error: El dato " + data + " no fue encontrado.");
        return result.data;
    }

    private Node searchRec(Node node, E data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp == 0) return node;
        else if (cmp < 0) return searchRec(node.left, data);
        else return searchRec(node.right, data);
    }

    // Método delete
    @Override
    public void delete(E data) throws ExceptionIsEmpty, ItemNotFound {
        if (isEmpty()) throw new ExceptionIsEmpty("Error: El BST está vacío.");
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node node, E data) throws ItemNotFound {
        if (node == null) throw new ItemNotFound("Error: El dato " + data + " no fue encontrado para eliminar.");
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            // Nodo encontrado, caso de eliminación
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            else {
                // Nodo con dos hijos: obtener sucesor mínimo
                Node minNode = findMinNode(node.right);
                node.data = minNode.data;
                node.right = deleteRec(node.right, minNode.data);
            }
        }
        return node;
    }

    // Encontrar nodo con mínimo valor en subárbol
    private Node findMinNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // ToString (In-orden para mostrar elementos ordenados)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

    // Recorrido In-Orden (privado)
    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }

    // Recorrido Pre-Orden
    private void preOrder(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString().trim();
    }

    // Recorrido Post-Orden
    private void postOrder(Node node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }

    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString().trim();
    }

    // Método público para In-Orden
    public String inOrder() {
        return toString();
    }

    // Métodos para encontrar mínimo y máximo valor público

    public E findMin() throws ItemNotFound {
        if (isEmpty()) throw new ItemNotFound("Error: El BST está vacío.");
        return findMinNode(root).data;
    }

    public E findMax() throws ItemNotFound {
        if (isEmpty()) throw new ItemNotFound("Error: El BST está vacío.");
        Node node = root;
        while (node.right != null) node = node.right;
        return node.data;
    }
    
}

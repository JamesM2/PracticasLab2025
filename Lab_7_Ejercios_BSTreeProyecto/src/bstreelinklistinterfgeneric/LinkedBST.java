package bstreelinklistinterfgeneric;

import bstreeInterface.BinarySearchTree;
import exceptions.*;

import java.util.*;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    
    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
        }
    }

    private Node root;

    public LinkedBST() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // ===== MÉTODOS DEL EJERCICIO ===== //

    @Override
    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty();
        root = null; // Al no haber referencias, el GC eliminará los nodos.
    }

    @Override
    public int countAllNodes() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty();
        return countAllNodes(root);
    }

    private int countAllNodes(Node node) {
        if (node == null) return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }

    @Override
    public int countNodes() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty();
        return countInternalNodes(root);
    }

    private int countInternalNodes(Node node) {
        if (node == null || (node.left == null && node.right == null)) return 0;
        return 1 + countInternalNodes(node.left) + countInternalNodes(node.right);
    }

    @Override
    public int height(E data) {
        Node node = searchNode(root, data);
        if (node == null) return -1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int height = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return height;
    }

    private Node searchNode(Node node, E data) {
        while (node != null) {
            int cmp = data.compareTo(node.data);
            if (cmp == 0) return node;
            node = (cmp < 0) ? node.left : node.right;
        }
        return null;
    }

    @Override
    public int amplitude(int nivel) {
        if (isEmpty()) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (currentLevel == nivel) return levelSize;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            currentLevel++;
        }
        return 0;
    }

    @Override
    public int areaBST() {
        if (isEmpty()) return 0;
        return countLeafNodes(root) * height(root.data);
    }

    private int countLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    @Override
    public void drawBST() {
        System.out.println(toString());
    }

    @Override
    public String parenthesize() {
        return parenthesize(root, "");
    }

    private String parenthesize(Node node, String indent) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(node.data).append("\n");
        sb.append(parenthesize(node.left, indent + "  "));
        sb.append(parenthesize(node.right, indent + "  "));
        return sb.toString();
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node node, E data) throws ItemDuplicated {
        if (node == null) return new Node(data);
        int cmp = data.compareTo(node.data);
        if (cmp == 0) throw new ItemDuplicated();
        if (cmp < 0) node.left = insert(node.left, data);
        else node.right = insert(node.right, data);
        return node;
    }

    @Override
    public E search(E data) throws ItemNotFound {
        Node result = searchNode(root, data);
        if (result == null) throw new ItemNotFound();
        return result.data;
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty();
        root = delete(root, data);
    }

    private Node delete(Node node, E data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp < 0) node.left = delete(node.left, data);
        else if (cmp > 0) node.right = delete(node.right, data);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node min = getMin(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }
        return node;
    }

    private Node getMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    @Override
    public String toString() {
        return toString(root, "");
    }

    private String toString(Node node, String prefix) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(node.data).append("\n");
        sb.append(toString(node.left, prefix + "  "));
        sb.append(toString(node.right, prefix + "  "));
        return sb.toString();
    }
}

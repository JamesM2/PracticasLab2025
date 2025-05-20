package bstreeInterface;

import exceptions.*;

public interface BinarySearchTree<E> {
    void insert(E data) throws ItemDuplicated;
    void delete(E data) throws ExceptionIsEmpty;
    E search(E data) throws ItemNotFound;
    boolean isEmpty();
    void destroyNodes() throws ExceptionIsEmpty;
    int countAllNodes() throws ExceptionIsEmpty;
    int countNodes() throws ExceptionIsEmpty;
    int height(E data);
    int amplitude(int nivel);
    int areaBST();
    void drawBST(); // simulación con texto
    String parenthesize();
}

package app;

import bstreeLinkedListGeneric.LinkedBST;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();

        try {
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);

            System.out.println("BST: " + bst);

            System.out.println("Buscando 40: " + bst.search(40));

            bst.delete(30);
            System.out.println("Después de eliminar 30: " + bst);

        } catch (ItemDuplicated | ItemNotFound | ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

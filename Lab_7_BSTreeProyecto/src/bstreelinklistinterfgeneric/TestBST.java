package bstreelinklistinterfgeneric;

import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;

public class TestBST {
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();
        try {
            bst.insert(50);
            bst.insert(75);
            bst.insert(100);
            bst.insert(200);
            bst.insert(400);
            bst.insert(700);
            // bst.insert(75); // Descomenta para probar excepci�n

            System.out.println("Recorrido In-Orden: " + bst.inOrder());
            System.out.println("Recorrido Pre-Orden: " + bst.preOrder());
            System.out.println("Recorrido Post-Orden: " + bst.postOrder());

            System.out.println("M�nimo en BST: " + bst.findMin());
            System.out.println("M�ximo en BST: " + bst.findMax());

            System.out.println("Buscando 200: " + bst.search(200));

            bst.delete(100);
            System.out.println("BST despu�s de eliminar 100: " + bst.inOrder());

            // bst.delete(999); // Prueba excepci�n ItemNotFound

        } catch (ItemDuplicated | ItemNotFound | ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        }
    }
}


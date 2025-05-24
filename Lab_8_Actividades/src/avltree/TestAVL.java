package avltree;

import exceptions.ItemDuplicated;

// Clase de prueba para el árbol AVL
public class TestAVL {

    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        try {
            avl.insert(30);
            avl.insert(20);
            avl.insert(10); // RSR

            avl.insert(40);
            avl.insert(50); // RSL

            avl.insert(45); // RDL

            avl.insert(5);
            avl.insert(15); // RDR

            avl.insert(1); // RSR

            System.out.println("Inserciones realizadas correctamente.");

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

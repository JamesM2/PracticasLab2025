package arboles;

// Clase principal para probar todas las funcionalidades
public class MainAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        // Insertar valores en el árbol AVL (Ejercicio 1 y 6)
        int[] datos = {50, 30, 70, 20, 40, 60, 80, 10, 25, 65};
        for (int valor : datos) {
            avl.root = avl.insert(avl.root, valor);
        }

        // Mostrar recorrido Preorden (Ejercicio 5)
        System.out.println("Recorrido Preorden:");
        avl.preOrder(avl.root);
        System.out.println();

        // Mostrar recorrido por Niveles (Ejercicio 3 y 4)
        System.out.println("Recorrido por Niveles:");
        avl.printLevelOrder(avl.root);
        System.out.println();

        // Eliminar un nodo (Ejercicio 2 y 6)
        System.out.println("Después de eliminar 25:");
        avl.root = avl.delete(avl.root, 25);
        avl.printLevelOrder(avl.root);
        System.out.println();
    }
}

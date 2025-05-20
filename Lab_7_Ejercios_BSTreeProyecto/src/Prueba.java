import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.*;

public class Prueba {

    // Programa de prueba para un árbol binario de búsqueda genérico
    public static void main(String[] args) {
        try {
            // Crear un árbol BST para enteros
            LinkedBST<Integer> bst = new LinkedBST<>();

            // Insertar valores en el árbol
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            // Mostrar el árbol
            System.out.println("Arbol dibujado:");
            bst.drawBST();

            // Mostrar altura del nodo con valor 30
            System.out.println("Altura del nodo 30: " + bst.height(30));

            // Mostrar cantidad de nodos en el nivel 2
            System.out.println("Amplitud nivel 2: " + bst.amplitude(2));

            // Mostrar área total del árbol
            System.out.println("Área del BST: " + bst.areaBST());

            // Mostrar árbol en formato parentizado
            System.out.println("Visualización parenthesize:");
            System.out.println(bst.parenthesize());

        } catch (Exception e) {
            // Mostrar error si ocurre alguno
            e.printStackTrace();
        }
    }
}

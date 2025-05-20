import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.*;

public class Prueba {

    // Programa de prueba para un �rbol binario de b�squeda gen�rico
    public static void main(String[] args) {
        try {
            // Crear un �rbol BST para enteros
            LinkedBST<Integer> bst = new LinkedBST<>();

            // Insertar valores en el �rbol
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            // Mostrar el �rbol
            System.out.println("Arbol dibujado:");
            bst.drawBST();

            // Mostrar altura del nodo con valor 30
            System.out.println("Altura del nodo 30: " + bst.height(30));

            // Mostrar cantidad de nodos en el nivel 2
            System.out.println("Amplitud nivel 2: " + bst.amplitude(2));

            // Mostrar �rea total del �rbol
            System.out.println("�rea del BST: " + bst.areaBST());

            // Mostrar �rbol en formato parentizado
            System.out.println("Visualizaci�n parenthesize:");
            System.out.println(bst.parenthesize());

        } catch (Exception e) {
            // Mostrar error si ocurre alguno
            e.printStackTrace();
        }
    }
}

package prueba;

import btree.BTree;

public class MainPrueba {
    public static void main(String[] args) {
        System.out.println("-- Inserci�n en �rbol B --\n");

        BTree<Integer> arbol = new BTree<>(5); // �rbol de orden 5

        int[] datos = {100, 50, 20, 70, 10, 30, 80, 90, 200, 25, 15, 5, 65, 35, 60, 18, 93, 94};

        for (int val : datos) {
            System.out.println("Insertando: " + val);
            arbol.insert(val);
            arbol.print(); // Mostrar el �rbol tras cada inserci�n
            System.out.println("--------------------------");
        }
    }
}

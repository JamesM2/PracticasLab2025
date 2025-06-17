package prueba;

import btree.BTree;

public class MainPrueba {
    public static void main(String[] args) {
        System.out.println("-- Inserci�n y b�squeda en �rbol B --\n");

        BTree<Integer> arbol = new BTree<>(5); // �rbol B de orden 5
        int[] datos = {100, 50, 20, 70, 10, 30, 80, 90, 200, 25, 15, 5, 65, 35, 60, 18, 93, 94};

        for (int valor : datos) {
            System.out.println("Insertando: " + valor);
            arbol.insert(valor);
            arbol.print();
            System.out.println("--------------------");
        }

        System.out.println("\n-- B�squeda --");
        int[] busquedas = {52, 100, 18, 200};

        for (int clave : busquedas) {
            boolean resultado = arbol.search(clave);
            System.out.println("Resultado de b�squeda de " + clave + ": " + resultado);
            System.out.println("--------------------");
        }
    }
}

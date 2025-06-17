package prueba;

import btree.BTree;
import model.RegistroEstudiante;

public class MainPruebaEstudiante {
    public static void main(String[] args) {
        BTree<RegistroEstudiante> arbol = new BTree<>(4);

        // Inserciones
        arbol.insert(new RegistroEstudiante(103, "Ana"));
        arbol.insert(new RegistroEstudiante(110, "Luis"));
        arbol.insert(new RegistroEstudiante(101, "Carlos"));
        arbol.insert(new RegistroEstudiante(120, "Lucía"));
        arbol.insert(new RegistroEstudiante(115, "David"));
        arbol.insert(new RegistroEstudiante(125, "Jorge"));
        arbol.insert(new RegistroEstudiante(140, "Camila"));
        arbol.insert(new RegistroEstudiante(108, "Rosa"));
        arbol.insert(new RegistroEstudiante(132, "Ernesto"));
        arbol.insert(new RegistroEstudiante(128, "Denis"));
        arbol.insert(new RegistroEstudiante(145, "Enrique"));
        arbol.insert(new RegistroEstudiante(122, "Karina"));
        arbol.insert(new RegistroEstudiante(108, "Juan")); // Duplicado, no se insertará

        System.out.println("-- Árbol B de Estudiantes --");
        arbol.print();

        System.out.println("\n-- Búsquedas --");
        System.out.println("115: " + arbol.buscarNombre(115));
        System.out.println("132: " + arbol.buscarNombre(132));
        System.out.println("999: " + arbol.buscarNombre(999));

        System.out.println("\n-- Inserción de nuevo estudiante --");
        arbol.insert(new RegistroEstudiante(106, "Sara"));
        arbol.print();
        System.out.println("106: " + arbol.buscarNombre(106));
    }
}

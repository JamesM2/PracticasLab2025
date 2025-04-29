package tareas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Lista de prueba con Strings
        List<String> lista = new ArrayList<>();
        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");

        // ====================== PRUEBA 1 ======================
        System.out.println("== 1. Buscar un elemento en lista genérica ==");
        System.out.println("Buscar 'Dos' en lista: " + Utilidades.buscarElemento(lista, "Dos")); // true
        System.out.println("Buscar 'Cuatro' en lista: " + Utilidades.buscarElemento(lista, "Cuatro")); // false
        System.out.println();

        // ====================== PRUEBA 2 ======================
        System.out.println("== 2. Invertir lista genérica ==");
        List<String> listaInvertida = Utilidades.invertirLista(lista);
        System.out.println("Lista original: " + lista);
        System.out.println("Lista invertida: " + listaInvertida);
        System.out.println();

        // ====================== PRUEBA 3 ======================
        System.out.println("== 3. Insertar nodos al final de lista enlazada ==");
        Node<String> listaEnlazada = null;
        listaEnlazada = Utilidades.insertarAlFinal(listaEnlazada, "A");
        listaEnlazada = Utilidades.insertarAlFinal(listaEnlazada, "B");
        listaEnlazada = Utilidades.insertarAlFinal(listaEnlazada, "C");
        System.out.print("Lista enlazada: ");
        Utilidades.imprimirLista(listaEnlazada);
        System.out.println();

        // ====================== PRUEBA 4 ======================
        System.out.println("== 4. Contar nodos en lista enlazada ==");
        int total = Utilidades.contarNodos(listaEnlazada);
        System.out.println("Cantidad de nodos: " + total);
        System.out.println();

        // ====================== PRUEBA 5 ======================
        System.out.println("== 5. Comparar dos listas enlazadas ==");
        Node<String> otraLista = null;
        otraLista = Utilidades.insertarAlFinal(otraLista, "A");
        otraLista = Utilidades.insertarAlFinal(otraLista, "B");
        otraLista = Utilidades.insertarAlFinal(otraLista, "C");
        boolean sonIguales = Utilidades.sonIguales(listaEnlazada, otraLista);
        System.out.println("¿Las listas son iguales?: " + sonIguales);
        System.out.println();

        // ====================== PRUEBA 6 ======================
        System.out.println("== 6. Concatenar dos listas enlazadas ==");
        Node<String> otraLista2 = null;
        otraLista2 = Utilidades.insertarAlFinal(otraLista2, "D");
        otraLista2 = Utilidades.insertarAlFinal(otraLista2, "E");

        Node<String> listaFinal = Utilidades.concatenarListas(listaEnlazada, otraLista2);
        System.out.print("Lista concatenada: ");
        Utilidades.imprimirLista(listaFinal);
    }
}

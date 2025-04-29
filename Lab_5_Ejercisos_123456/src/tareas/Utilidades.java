package tareas;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {

    // 1. Método genérico que busca un valor en una lista y devuelve true si lo encuentra
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento.equals(valor)) {
                return true; // Valor encontrado
            }
        }
        return false; // Valor no encontrado
    }

    // 2. Método genérico que invierte una lista y devuelve una nueva lista con los elementos al revés
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> listaInvertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            listaInvertida.add(lista.get(i)); // Agrega desde el último al primero
        }
        return listaInvertida;
    }

    // 3. Método genérico que inserta un nodo al final de una lista enlazada
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor); // Crea un nuevo nodo con el valor
        if (head == null) {
            return nuevo; // Si la lista está vacía, el nuevo nodo es la cabeza
        }
        Node<T> actual = head;
        while (actual.next != null) {
            actual = actual.next; // Avanza al final de la lista
        }
        actual.next = nuevo; // Inserta el nuevo nodo al final
        return head;
    }

    // 4. Método genérico que cuenta y retorna la cantidad de nodos en una lista enlazada
    public static <T> int contarNodos(Node<T> head) {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;         // Suma uno por cada nodo
            actual = actual.next; // Avanza al siguiente nodo
        }
        return contador;
    }

    // 5. Método genérico que compara dos listas enlazadas y retorna true si son iguales en orden y contenido
    public static <T> boolean sonIguales(Node<T> head1, Node<T> head2) {
        Node<T> actual1 = head1;
        Node<T> actual2 = head2;

        while (actual1 != null && actual2 != null) {
            if (!actual1.data.equals(actual2.data)) {
                return false; // Los datos son diferentes
            }
            actual1 = actual1.next;
            actual2 = actual2.next;
        }

        return actual1 == null && actual2 == null; // Ambas listas deben terminar al mismo tiempo
    }

    // 6. Método genérico que concatena dos listas enlazadas y retorna una nueva lista combinada
    public static <T> Node<T> concatenarListas(Node<T> head1, Node<T> head2) {
        if (head1 == null) return head2; // Si la primera lista está vacía, retorna la segunda
        Node<T> actual = head1;
        while (actual.next != null) {
            actual = actual.next; // Llega al final de la primera lista
        }
        actual.next = head2; // Conecta la segunda lista al final de la primera
        return head1;
    }

    // Método auxiliar para imprimir una lista enlazada en consola
    public static <T> void imprimirLista(Node<T> head) {
        Node<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null"); // Marca el final de la lista
    }
}

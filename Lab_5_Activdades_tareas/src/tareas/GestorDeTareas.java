package tareas;

import java.util.ArrayList;
import java.util.List;

// Clase genérica que gestiona una lista de tareas
public class GestorDeTareas<T> {
    private Node<T> head; // Inicio de la lista enlazada
    private List<T> tareasCompletadas; // Lista de tareas ya terminadas (List<T>)

    // Constructor
    public GestorDeTareas() {
        this.head = null;
        this.tareasCompletadas = new ArrayList<>();
    }

    // Agrega una tarea al final de la lista
    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevo;
        }
    }

    // Elimina una tarea si existe
    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;

        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }

        Node<T> actual = head;
        while (actual.next != null && !actual.next.data.equals(tarea)) {
            actual = actual.next;
        }

        if (actual.next != null) {
            actual.next = actual.next.next;
            return true;
        }

        return false;
    }

    // Verifica si la lista contiene una tarea
    public boolean contieneTarea(T tarea) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.data.equals(tarea)) return true;
            actual = actual.next;
        }
        return false;
    }

    // Imprime todas las tareas actuales
    public void imprimirTareas() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.data);
            actual = actual.next;
        }
    }

    // Cuenta cuántas tareas hay en la lista
    public int contarTareas() {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }

    // Obtiene la tarea con mayor prioridad (solo si T es Tarea)
    public T obtenerTareaMasPrioritaria() {
        if (head == null) return null;

        T masPrioritaria = head.data;
        Node<T> actual = head.next;

        while (actual != null) {
            if (masPrioritaria instanceof Tarea && actual.data instanceof Tarea) {
                Tarea t1 = (Tarea) masPrioritaria;
                Tarea t2 = (Tarea) actual.data;
                if (t2.getPrioridad() > t1.getPrioridad()) {
                    masPrioritaria = actual.data;
                }
            }
            actual = actual.next;
        }

        return masPrioritaria;
    }

    // Invierte el orden de la lista enlazada
    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = head;
        Node<T> siguiente;

        while (actual != null) {
            siguiente = actual.next;
            actual.next = anterior;
            anterior = actual;
            actual = siguiente;
        }

        head = anterior;
    }

    // Marca una tarea como completada y la mueve a la lista de completadas
    public boolean completarTarea(T tarea) {
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea);
            return true;
        }
        return false;
    }

    // Imprime la lista de tareas completadas
    public void imprimirTareasCompletadas() {
        System.out.println("Tareas completadas:");
        for (T t : tareasCompletadas) {
            System.out.println(t);
        }
    }
}

package listlinked;

// Clase de lista enlazada simple
public class ListLinked<E> {

    private Node<E> head; // Nodo inicial

    public ListLinked() {
        head = null; // La lista comienza vacía
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data); // Crear nuevo nodo
        newNode.next = head; // Apuntar al anterior
        head = newNode; // Actualizar cabeza
    }

    public boolean remove(E data) {
        Node<E> current = head; // Nodo actual
        Node<E> prev = null; // Nodo anterior

        while (current != null) {
            if (current.data.equals(data)) {
                if (prev == null) {
                    head = current.next; // Eliminar cabeza
                } else {
                    prev.next = current.next; // Saltar el nodo
                }
                return true; // Eliminado
            }
            prev = current;
            current = current.next;
        }
        return false; // No encontrado
    }

    public boolean contains(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }

    public String toString() {
        String result = "";
        Node<E> current = head;
        while (current != null) {
            result += current.data.toString();
            current = current.next;
        }
        return result;
    }

    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            Node<E> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private static class Node<E> {
        E data; // Dato del nodo
        Node<E> next; // Siguiente nodo

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}

package listlinked;

public class ListLinked<E> {
    public static class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;

    public ListLinked() {
        head = null;
    }


     //Agrega un nuevo elemento al inicio de la lista

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }


     //Verifica si un elemento existe en la lista

    public boolean contains(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }


     //Elimina un elemento de la lista
    public boolean remove(E data) {
        Node<E> current = head, prev = null;
        while (current != null) {
            if (current.data.equals(data)) {
                if (prev == null) head = current.next;
                else prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    //Devuelve el nodo inicial (head) de la lista
     
    public Node<E> getHead() {
        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}

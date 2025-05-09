package ejercicio1;

import actividad1.Stack;
import actividad1.ExceptionIsEmpty;

// Implementación de la pila usando una lista enlazada
public class StackLink<E> implements Stack<E> {
    private Node<E> top;  // Referencia al nodo superior de la pila

    public StackLink() {
        this.top = null;
    }

    // Agrega un nuevo elemento en el tope de la pila
    public void push(E x) {
        Node<E> nuevo = new Node<>(x);
        nuevo.setNext(top);
        top = nuevo;
    }

    // Elimina y retorna el elemento del tope de la pila
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("No se puede hacer pop, la pila está vacía.");
        }
        E dato = top.getData();
        top = top.getNext();
        return dato;
    }

    // Retorna el elemento del tope sin eliminarlo
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("No se puede acceder al tope, la pila está vacía.");
        }
        return top.getData();
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return top == null;
    }

    // Representación en texto de los elementos de la pila
    public String toString() {
        String cadena = "";
        Node<E> aux = top;
        while (aux != null) {
            cadena += aux.getData() + " ";
            aux = aux.getNext();
        }
        return cadena.trim();
    }
}

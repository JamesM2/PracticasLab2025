package graph;

import listlinked.ListLinked;

// Clase para representar un v�rtice
public class Vertex<E> {
    private E data; // Dato del v�rtice
    protected ListLinked<Edge<E>> listAdj; // Lista de adyacencias

    public Vertex(E data) {
        this.data = data; // Asignar dato
        listAdj = new ListLinked<>(); // Crear lista vac�a
    }

    public E getData() {
        return data; // Obtener dato
    }

    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data); // Comparar datos
        }
        return false;
    }

    public String toString() {
        return this.data + " -> " + listAdj.toString() + "\n"; // Mostrar v�rtice y adyacencias
    }
}

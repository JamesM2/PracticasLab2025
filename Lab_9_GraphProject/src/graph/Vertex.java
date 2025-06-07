package graph;

import listlinked.ListLinked;


 //Representa un vértice del grafo, con una lista de adyacencias

public class Vertex<E> {
    private E data;
    protected ListLinked<Edge<E>> listAdj;

    public Vertex(E data) {
        this.data = data;
        listAdj = new ListLinked<>();
    }

    public E getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    public String toString() {
        return this.data + ": " + listAdj.toString();
    }
}

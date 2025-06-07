package graph;

import listlinked.ListLinked;
import java.util.HashSet;
import java.util.Set;

// Clase principal del grafo
public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex; // Lista de vértices

    public GraphLink() {
        listVertex = new ListLinked<>(); // Iniciar lista vacía
    }

    public void insertVertex(E data) {
        if (!listVertex.contains(new Vertex<>(data))) {
            listVertex.add(new Vertex<>(data)); // Agregar si no existe
        }
    }

    public void insertEdge(E v1, E v2) {
        Vertex<E> vertex1 = searchVertex(v1); // Buscar vértice origen
        Vertex<E> vertex2 = searchVertex(v2); // Buscar vértice destino
        if (vertex1 != null && vertex2 != null) {
            vertex1.listAdj.add(new Edge<>(vertex2)); // Añadir arista ida
            vertex2.listAdj.add(new Edge<>(vertex1)); // Añadir arista vuelta (no dirigido)
        }
    }

    public Vertex<E> searchVertex(E data) {
        for (Vertex<E> v : listVertex) {
            if (v.getData().equals(data)) return v; // Buscar por dato
        }
        return null;
    }

    public boolean searchEdge(E v1, E v2) {
        Vertex<E> vertex1 = searchVertex(v1);
        Vertex<E> vertex2 = searchVertex(v2);
        if (vertex1 != null && vertex2 != null) {
            return vertex1.listAdj.contains(new Edge<>(vertex2)); // Verificar conexión
        }
        return false;
    }

    public void removeEdge(E v1, E v2) {
        Vertex<E> vertex1 = searchVertex(v1);
        Vertex<E> vertex2 = searchVertex(v2);
        if (vertex1 != null && vertex2 != null) {
            vertex1.listAdj.remove(new Edge<>(vertex2)); // Eliminar ida
            vertex2.listAdj.remove(new Edge<>(vertex1)); // Eliminar vuelta
        }
    }

    public void removeVertex(E data) {
        Vertex<E> v = searchVertex(data);
        if (v != null) {
            for (Vertex<E> u : listVertex) {
                u.listAdj.remove(new Edge<>(v)); // Eliminar todas las conexiones
            }
            listVertex.remove(v); // Eliminar el vértice
        }
    }

    public void dfs(E start) {
        Vertex<E> v = searchVertex(start);
        if (v == null) return;
        Set<Vertex<E>> visited = new HashSet<>(); // Para marcar visitados
        dfsRec(v, visited); // Llamada recursiva
    }

    private void dfsRec(Vertex<E> v, Set<Vertex<E>> visited) {
        visited.add(v); // Marcar como visitado
        System.out.print(v.getData() + " "); // Mostrar
        for (Edge<E> e : v.listAdj) {
            Vertex<E> dest = e.getRefDest();
            if (!visited.contains(dest)) {
                dfsRec(dest, visited); // Recorrer siguiente
            }
        }
    }

    public String toString() {
        return listVertex.toString(); // Mostrar lista de vértices
    }
}

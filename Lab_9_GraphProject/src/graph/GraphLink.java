package graph;

import java.util.Queue;
import listlinked.ListLinked;
import java.util.HashSet;
import java.util.Set;

public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<>();
    }
    //Inserta un nuevo vértice si no existe

    public void insertVertex(E data) {
        if (!searchVertex(data)) {
            listVertex.add(new Vertex<>(data));
        }
    }

     //Busca si un vértice existe en el grafo
    public boolean searchVertex(E data) {
        var node = listVertex.getHead();
        while (node != null) {
            if (node.data.getData().equals(data)) return true;
            node = node.next;
        }
        return false;
    }

     //Obtiene un vértice a partir de su dato
    private Vertex<E> getVertex(E data) {
        var node = listVertex.getHead();
        while (node != null) {
            if (node.data.getData().equals(data)) return node.data;
            node = node.next;
        }
        return null;
    }

     //Inserta una arista entre dos vértices
    public void insertEdge(E verOri, E verDes) {
        Vertex<E> v = getVertex(verOri);
        Vertex<E> w = getVertex(verDes);
        if (v != null && w != null && !v.listAdj.contains(new Edge<>(w))) {
            v.listAdj.add(new Edge<>(w));
            w.listAdj.add(new Edge<>(v)); // porque es no dirigido
        }
    }

     //Verifica si existe una arista entre dos vértices
    public boolean searchEdge(E v, E z) {
        Vertex<E> vert = getVertex(v);
        Vertex<E> dest = getVertex(z);
        if (vert != null && dest != null) {
            return vert.listAdj.contains(new Edge<>(dest));
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        var node = listVertex.getHead();
        while (node != null) {
            sb.append(node.data.toString()).append("\n");
            node = node.next;
        }
        return sb.toString();
   
    }
    
    //Elimina la arista entre dos vértices
    public boolean removeEdge(E verOri, E verDes) {
        Vertex<E> v = getVertex(verOri);
        Vertex<E> w = getVertex(verDes);
        if (v != null && w != null) {
            boolean removedFromV = v.listAdj.remove(new Edge<>(w));
            boolean removedFromW = w.listAdj.remove(new Edge<>(v));
            return removedFromV && removedFromW;
        }
        return false;
    }
     //Elimina un vértice y todas sus aristas relacionadas
    public boolean removeVertex(E data) {
        Vertex<E> v = getVertex(data);
        if (v == null) return false;

        // Eliminar v de la lista de adyacencia de todos los demás vértices
        var node = listVertex.getHead();
        while (node != null) {
            node.data.listAdj.remove(new Edge<>(v));
            node = node.next;
        }

        // Eliminar vértice de la lista principal
        return listVertex.remove(v);
    }
    //Recorrido en anchura (BFS)
    public void bfs(E start) {
        Vertex<E> startVertex = getVertex(start);
        if (startVertex == null) {
            System.out.println("Vértice no encontrado");
            return;
        }
        Set<Vertex<E>> visited = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);
        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            Vertex<E> vertex = queue.poll();
            System.out.print(vertex.getData() + " ");

            var node = vertex.listAdj.getHead();
            while (node != null) {
                Vertex<E> adjVertex = node.data.getRefDest();
                if (!visited.contains(adjVertex)) {
                    visited.add(adjVertex);
                    queue.add(adjVertex);
                }
                node = node.next;
            }
        }
        System.out.println();
    }
     //Recorrido en profundidad (DFS)
    public void dfs(E start) {
        Vertex<E> startVertex = getVertex(start);
        if (startVertex == null) {
            System.out.println("Vértice no encontrado");
            return;
        }
        Set<Vertex<E>> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(startVertex, visited);
        System.out.println();
    }

    private void dfsHelper(Vertex<E> vertex, Set<Vertex<E>> visited) {
        System.out.print(vertex.getData() + " ");
        visited.add(vertex);

        var node = vertex.listAdj.getHead();
        while (node != null) {
            Vertex<E> adjVertex = node.data.getRefDest();
            if (!visited.contains(adjVertex)) {
                dfsHelper(adjVertex, visited);
            }
            node = node.next;
        }
    }

}

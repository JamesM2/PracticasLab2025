package graph;

import java.util.*;

// Clase que representa un grafo no dirigido ponderado usando lista de adyacencia
public class GraphLink<V> {
    // Mapa que guarda cada vértice y su lista de aristas salientes
    private Map<V, List<Edge<V>>> adjacencyList;

    // Constructor
    public GraphLink() {
        adjacencyList = new HashMap<>();
    }

    // Método para insertar un vértice, si no existe
    public void insertVertex(V v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    // Método para insertar una arista sin peso (ponderación 1)
    public void insertEdge(V v, V z) {
        insertEdgeWeight(v, z, 1);
    }

    // Método para insertar una arista con peso entre v y z (no dirigido)
    public void insertEdgeWeight(V v, V z, int w) {
        insertVertex(v);
        insertVertex(z);

        adjacencyList.get(v).add(new Edge<>(v, z, w));
        adjacencyList.get(z).add(new Edge<>(z, v, w));
    }

    // Método que retorna la lista de vecinos de un vértice v
    public List<V> getNeighbors(V v) {
        List<V> neighbors = new ArrayList<>();
        if (!adjacencyList.containsKey(v)) return neighbors;

        for (Edge<V> edge : adjacencyList.get(v)) {
            neighbors.add(edge.to);
        }
        return neighbors;
    }

    // Método BFS que imprime los vértices visitados desde v
    public void bfs(V v) {
        if (!adjacencyList.containsKey(v)) {
            System.out.println("El vértice no existe.");
            return;
        }

        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        queue.add(v);
        visited.add(v);

        System.out.print("Recorrido BFS desde " + v + ": ");

        while (!queue.isEmpty()) {
            V current = queue.poll();
            System.out.print(current + " ");

            for (V neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Método BFS que devuelve el camino (lista) entre v y z, si existe
    public ArrayList<V> bfsPath(V v, V z) {
        ArrayList<V> path = new ArrayList<>();
        if (!adjacencyList.containsKey(v) || !adjacencyList.containsKey(z)) {
            return path; // lista vacía si no existen vértices
        }

        Queue<V> queue = new LinkedList<>();
        Map<V, V> parent = new HashMap<>();
        Set<V> visited = new HashSet<>();

        queue.add(v);
        visited.add(v);
        parent.put(v, null);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            if (current.equals(z)) break;

            for (V neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }

        if (!parent.containsKey(z)) return path; // No encontró camino

        for (V at = z; at != null; at = parent.get(at)) {
            path.add(0, at);
        }
        return path;
    }

    // Método que determina si el grafo es conexo
    public boolean isConexo() {
        if (adjacencyList.isEmpty()) return true;

        V start = adjacencyList.keySet().iterator().next();
        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (Edge<V> edge : adjacencyList.get(current)) {
                if (!visited.contains(edge.to)) {
                    visited.add(edge.to);
                    queue.add(edge.to);
                }
            }
        }
        return visited.size() == adjacencyList.size();
    }

    // Método que calcula la ruta más corta entre v y z usando Dijkstra
    public ArrayList<V> shortPath(V v, V z) {
        ArrayList<V> path = new ArrayList<>();
        if (!adjacencyList.containsKey(v) || !adjacencyList.containsKey(z)) {
            return path;
        }

        Map<V, Integer> dist = new HashMap<>();
        Map<V, V> prev = new HashMap<>();
        PriorityQueue<V> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        Set<V> visited = new HashSet<>();

        for (V vertex : adjacencyList.keySet()) {
            dist.put(vertex, Integer.MAX_VALUE);
            prev.put(vertex, null);
        }
        dist.put(v, 0);
        pq.add(v);

        while (!pq.isEmpty()) {
            V current = pq.poll();
            if (current.equals(z)) break;
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Edge<V> edge : adjacencyList.get(current)) {
                V neighbor = edge.to;
                int newDist = dist.get(current) + edge.weight;
                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    prev.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        if (dist.get(z) == Integer.MAX_VALUE) return path;

        for (V at = z; at != null; at = prev.get(at)) {
            path.add(0, at);
        }
        return path;
    }

    // Método que retorna un stack con la ruta más corta entre v y w usando Dijkstra
    public Stack<V> Dijkstra(V v, V w) {
        ArrayList<V> path = shortPath(v, w);
        Stack<V> stack = new Stack<>();
        for (V vertex : path) {
            stack.push(vertex);
        }
        return stack;
    }

    // Nuevo método: busca si existe arista entre v1 y v2
    public boolean searchEdge(V v1, V v2) {
        if (!adjacencyList.containsKey(v1)) return false;
        for (Edge<V> edge : adjacencyList.get(v1)) {
            if (edge.to.equals(v2)) {
                return true;
            }
        }
        return false;
    }

    // Nuevo método: recorrido DFS desde un vértice dado
    public void dfs(V start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("El vértice no existe.");
            return;
        }

        Set<V> visited = new HashSet<>();
        Stack<V> stack = new Stack<>();
        stack.push(start);

        System.out.print("Recorrido DFS desde " + start + ": ");

        while (!stack.isEmpty()) {
            V current = stack.pop();
            if (!visited.contains(current)) {
                System.out.print(current + " ");
                visited.add(current);

                for (Edge<V> edge : adjacencyList.get(current)) {
                    if (!visited.contains(edge.to)) {
                        stack.push(edge.to);
                    }
                }
            }
        }
        System.out.println();
    }

    // Nuevo método: elimina arista entre v1 y v2 (bidireccional)
    public boolean removeEdge(V v1, V v2) {
        boolean removed = false;
        if (!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) return false;

        removed = adjacencyList.get(v1).removeIf(edge -> edge.to.equals(v2));
        removed = adjacencyList.get(v2).removeIf(edge -> edge.to.equals(v1)) || removed;

        return removed;
    }

    // Nuevo método: elimina vértice y todas sus aristas
    public boolean removeVertex(V v) {
        if (!adjacencyList.containsKey(v)) return false;

        // Remover todas las aristas que apuntan a v
        for (V vertex : adjacencyList.keySet()) {
            adjacencyList.get(vertex).removeIf(edge -> edge.to.equals(v));
        }

        // Remover el vértice v
        adjacencyList.remove(v);

        return true;
    }
}


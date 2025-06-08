package graph;

import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

//Grafo no dirigido ponderado usando lista única de aristas
public class GraphListEdge<V> {
 // Lista que contiene todas las aristas del grafo
 private List<Edge<V>> edges;
 // Conjunto para mantener los vértices únicos del grafo
 private Set<V> vertices;

 // Constructor
 public GraphListEdge() {
     edges = new ArrayList<>();
     vertices = new HashSet<>();
 }

 // Inserta un vértice, solo si no existe
 public void insertVertex(V v) {
     vertices.add(v);
 }

 // Inserta arista sin peso (peso 1)
 public void insertEdge(V v, V z) {
     insertEdgeWeight(v, z, 1);
 }

 // Inserta arista con peso (no dirigido)
 public void insertEdgeWeight(V v, V z, int w) {
     insertVertex(v);
     insertVertex(z);
     // Agrega solo una arista porque es no dirigido
     edges.add(new Edge<>(v, z, w));
 }

 // Obtiene la lista de vecinos de un vértice v
 public List<V> getNeighbors(V v) {
     List<V> neighbors = new ArrayList<>();
     for (Edge<V> e : edges) {
         if (e.from.equals(v)) neighbors.add(e.to);
         else if (e.to.equals(v)) neighbors.add(e.from);
     }
     return neighbors;
 }

 // BFS desde v, imprime recorrido
 public void bfs(V v) {
     if (!vertices.contains(v)) {
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
                 visited.add(neighbor);
                 queue.add(neighbor);
             }
         }
     }
     System.out.println();
 }

 // BFS que retorna el camino entre v y z
 public ArrayList<V> bfsPath(V v, V z) {
     ArrayList<V> path = new ArrayList<>();
     if (!vertices.contains(v) || !vertices.contains(z)) return path;

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

     if (!parent.containsKey(z)) return path;

     for (V at = z; at != null; at = parent.get(at)) {
         path.add(0, at);
     }
     return path;
 }

 // Verifica si el grafo es conexo
 public boolean isConexo() {
     if (vertices.isEmpty()) return true;

     V start = vertices.iterator().next();
     Set<V> visited = new HashSet<>();
     Queue<V> queue = new LinkedList<>();
     queue.add(start);
     visited.add(start);

     while (!queue.isEmpty()) {
         V current = queue.poll();
         for (V neighbor : getNeighbors(current)) {
             if (!visited.contains(neighbor)) {
                 visited.add(neighbor);
                 queue.add(neighbor);
             }
         }
     }
     return visited.size() == vertices.size();
 }

 // Ruta más corta usando Dijkstra
 public ArrayList<V> shortPath(V v, V z) {
     ArrayList<V> path = new ArrayList<>();
     if (!vertices.contains(v) || !vertices.contains(z)) return path;

     Map<V, Integer> dist = new HashMap<>();
     Map<V, V> prev = new HashMap<>();
     PriorityQueue<V> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
     Set<V> visited = new HashSet<>();

     for (V vertex : vertices) {
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

         for (V neighbor : getNeighbors(current)) {
             int weight = getWeight(current, neighbor);
             int newDist = dist.get(current) + weight;
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

 // Obtiene el peso de la arista entre v y z
 private int getWeight(V v, V z) {
     for (Edge<V> e : edges) {
         if ((e.from.equals(v) && e.to.equals(z)) || (e.from.equals(z) && e.to.equals(v))) {
             return e.weight;
         }
     }
     return Integer.MAX_VALUE; // No existe la arista
 }

 // Devuelve la ruta más corta como Stack
 public Stack<V> Dijkstra(V v, V w) {
     ArrayList<V> path = shortPath(v, w);
     Stack<V> stack = new Stack<>();
     for (V vertex : path) {
         stack.push(vertex);
     }
     return stack;
 }
}

package graph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class PruebaGraph {
    public static void main(String[] args) {
        // Crear instancia del grafo
        GraphLink<String> graph = new GraphLink<>();

        // Insertar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // Insertar aristas con peso
        graph.insertEdgeWeight("A", "B", 2);
        graph.insertEdgeWeight("A", "C", 5);
        graph.insertEdgeWeight("B", "C", 1);
        graph.insertEdgeWeight("B", "D", 3);
        graph.insertEdgeWeight("C", "D", 2);
        graph.insertEdgeWeight("D", "E", 1);

        // Imprimir recorrido BFS desde "A"
        System.out.println("== Recorrido BFS ==");
        graph.bfs("A");

        // Obtener y mostrar camino BFS de A a E
        System.out.println("\n== Camino BFS desde A hasta E ==");
        System.out.println(graph.bfsPath("A", "E"));

        // Mostrar si el grafo es conexo
        System.out.println("\n== ¿El grafo es conexo? ==");
        System.out.println(graph.isConexo());

        // Mostrar ruta más corta entre A y E
        System.out.println("\n== Ruta más corta entre A y E (Dijkstra) ==");
        System.out.println(graph.shortPath("A", "E"));

        // Mostrar ruta más corta entre A y E como Stack
        System.out.println("\n== Ruta más corta como Stack (Dijkstra) ==");
        Stack<String> stack = graph.Dijkstra("A", "E");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

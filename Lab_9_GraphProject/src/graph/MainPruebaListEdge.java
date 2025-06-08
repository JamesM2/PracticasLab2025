package graph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class MainPruebaListEdge {
    public static void main(String[] args) {
        GraphListEdge<String> graph = new GraphListEdge<>();

        // Insertar v�rtices (opcional, porque insertEdgeWeight inserta autom�ticamente)
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

        // Pruebas
        System.out.println("== Recorrido BFS ==");
        graph.bfs("A");

        System.out.println("\n== Camino BFS desde A hasta E ==");
        System.out.println(graph.bfsPath("A", "E"));

        System.out.println("\n== �El grafo es conexo? ==");
        System.out.println(graph.isConexo());

        System.out.println("\n== Ruta m�s corta entre A y E (Dijkstra) ==");
        System.out.println(graph.shortPath("A", "E"));

        System.out.println("\n== Ruta m�s corta como Stack (Dijkstra) ==");
        Stack<String> stack = graph.Dijkstra("A", "E");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

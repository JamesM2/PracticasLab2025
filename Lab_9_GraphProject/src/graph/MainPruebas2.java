	package graph;

	public class MainPruebas2 {
	    public static void main(String[] args) {
	        GraphLink<String> grafo = new GraphLink<>();

	        grafo.insertVertex("v");
	        grafo.insertVertex("w");
	        grafo.insertVertex("z");
	        grafo.insertVertex("x");

	        grafo.insertEdge("v", "w");
	        grafo.insertEdge("v", "z");
	        grafo.insertEdge("w", "x");
	        grafo.insertEdge("x", "x");

	        System.out.println("Grafo:");
	        System.out.println(grafo);

	        System.out.println("¿Existe v-w?: " + grafo.searchEdge("v", "w"));
	        System.out.println("¿Existe z-x?: " + grafo.searchEdge("z", "x"));

	        // Probar DFS
	        grafo.dfs("v");

	        // Probar BFS
	        grafo.bfs("v");

	        // Probar eliminar arista A-C
	        System.out.println("Eliminando arista A-C");
	        grafo.removeEdge("A", "C");
	        System.out.println(grafo);

	        // Probar eliminar vértice D
	        System.out.println("Eliminando vértice D");
	        grafo.removeVertex("D");
	        System.out.println(grafo);
	    }
	}

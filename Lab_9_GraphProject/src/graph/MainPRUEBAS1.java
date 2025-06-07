
	package graph;

	public class MainPRUEBAS1 {
	    public static void main(String[] args) {
	        GraphLink<String> grafo = new GraphLink<>();

	        grafo.insertVertex("A");
	        grafo.insertVertex("B");
	        grafo.insertVertex("C");

	        grafo.insertEdge("A", "B");
	        grafo.insertEdge("A", "C");

	        System.out.println("Grafo:");
	        System.out.println(grafo);

	        System.out.println("¿Existe A-B?: " + grafo.searchEdge("A", "B"));
	        System.out.println("¿Existe B-C?: " + grafo.searchEdge("B", "C"));
	    }
	}

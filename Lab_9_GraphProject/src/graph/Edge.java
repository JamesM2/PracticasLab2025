package graph;
//Clase que representa una arista entre dos vértices con peso
public class Edge<V> {
 // Vértice origen
 public V from;
 // Vértice destino
 public V to;
 // Peso de la arista
 public int weight;

 // Constructor que recibe vértice origen, destino y peso
 public Edge(V from, V to, int weight) {
     this.from = from;
     this.to = to;
     this.weight = weight;
 }
}

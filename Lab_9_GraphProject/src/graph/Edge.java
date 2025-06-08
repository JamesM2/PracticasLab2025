package graph;
//Clase que representa una arista entre dos v�rtices con peso
public class Edge<V> {
 // V�rtice origen
 public V from;
 // V�rtice destino
 public V to;
 // Peso de la arista
 public int weight;

 // Constructor que recibe v�rtice origen, destino y peso
 public Edge(V from, V to, int weight) {
     this.from = from;
     this.to = to;
     this.weight = weight;
 }
}

package tareas;

//Clase Node<T> representa un nodo de una lista enlazada genérica
public class Node<T> {

	T data;           // Valor del nodo
 
	Node<T> next;     // Referencia al siguiente nodo

 
	public Node(T data) {
     
		this.data = data;
     
		this.next = null;
 }
}


package tareas;

//Clase genérica de nodo para la lista enlazada
public class Node<T> {
 T data; // Contenido del nodo
 Node<T> next; // Referencia al siguiente nodo

 // Constructor del nodo
 public Node(T data) {
     this.data = data;
     this.next = null;
 }
}

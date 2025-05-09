import ejercicio2.Queue;
import ejercicio2.QueueArray;
import ejercicio2.ExceptionIsEmpty;

// Prueba de la cola implementada con arreglo
public class Test5 {
    public static void main(String[] args) {
        try {
            Queue<String> cola = new QueueArray<>(4); // Capacidad máxima de 4

            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            cola.enqueue("D");
            cola.enqueue("E"); // Este no se inserta

            System.out.println("Cola actual: " + cola);
            System.out.println("Frente: " + cola.front());
            System.out.println("Último: " + cola.back());

            cola.dequeue(); // Elimina A
            cola.dequeue(); // Elimina B

            cola.enqueue("E");
            cola.enqueue("F");

            System.out.println("Cola después de eliminar e insertar: " + cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

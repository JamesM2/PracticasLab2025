import actividad3.PriorityQueue;
import actividad3.PriorityQueueLinkSort;
import actividad1.ExceptionIsEmpty;

public class Test3 {
    public static void main(String[] args) {
        try {
            // Creamos una cola de prioridad con datos String y prioridades Integer
            PriorityQueue<String, Integer> cola = new PriorityQueueLinkSort<>();

            // Insertamos elementos con distintas prioridades
            cola.enqueue("Tarea A", 2);
            cola.enqueue("Tarea B", 5);
            cola.enqueue("Tarea C", 1);
            cola.enqueue("Tarea D", 3);

            // Mostramos el contenido de la cola ordenado por prioridad
            System.out.println("Cola de prioridad: " + cola);

            // Mostramos el frente y el final
            System.out.println("Frente: " + cola.front()); // mayor prioridad
            System.out.println("Final: " + cola.back());   // menor prioridad

            // Quitamos el elemento con mayor prioridad (frente)
            System.out.println("Eliminando: " + cola.dequeue());

            // Mostramos cómo quedó la cola después del dequeue
            System.out.println("Cola actualizada: " + cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}

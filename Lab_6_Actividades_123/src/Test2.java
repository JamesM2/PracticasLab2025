import actividad2.Queue;
import actividad2.QueueLink;
import actividad1.ExceptionIsEmpty;

public class Test2 {
    public static void main(String[] args) {
        try {
            // Cola de enteros
            Queue<Integer> colaEnteros = new QueueLink<>();
            colaEnteros.enqueue(100);
            colaEnteros.enqueue(200);
            colaEnteros.enqueue(300);
            System.out.println("Cola de enteros: " + colaEnteros);
            System.out.println("Frente: " + colaEnteros.front());
            System.out.println("Fondo: " + colaEnteros.back());
            System.out.println("Eliminado (dequeue): " + colaEnteros.dequeue());
            System.out.println("Cola después del dequeue: " + colaEnteros);

            // Cola de cadenas
            Queue<String> colaCadenas = new QueueLink<>();
            colaCadenas.enqueue("Uno");
            colaCadenas.enqueue("Dos");
            colaCadenas.enqueue("Tres");
            System.out.println("Cola de cadenas: " + colaCadenas);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}

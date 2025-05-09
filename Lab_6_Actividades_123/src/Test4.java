import actividad1.Stack;
import actividad1.ExceptionIsEmpty;
import ejercicio1.StackLink;

public class Test4 {
    public static void main(String[] args) {
        try {
            // Pila de enteros
            Stack<Integer> pilaEnteros = new StackLink<>();
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);
            System.out.println("Pila de enteros: " + pilaEnteros);

            pilaEnteros.pop();
            System.out.println("Después de un pop: " + pilaEnteros);
            System.out.println("Tope actual: " + pilaEnteros.top());

            // Pila de cadenas
            Stack<String> pilaCadenas = new StackLink<>();
            pilaCadenas.push("Uno");
            pilaCadenas.push("Dos");
            pilaCadenas.push("Tres");
            System.out.println("Pila de cadenas: " + pilaCadenas);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

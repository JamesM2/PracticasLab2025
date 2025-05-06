import actividad1.Stack;
import actividad1.StackArray;
import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            Stack<Integer> pilaEnteros = new StackArray<>(5);
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);
            System.out.println(pilaEnteros); // [30, 20, 10]

            System.out.println("Top: " + pilaEnteros.top());
            System.out.println("Pop: " + pilaEnteros.pop());
            System.out.println(pilaEnteros); // [20, 10]

            Stack<String> pilaStrings = new StackArray<>(3);
            pilaStrings.push("A");
            pilaStrings.push("B");
            System.out.println(pilaStrings); // [B, A]

        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}

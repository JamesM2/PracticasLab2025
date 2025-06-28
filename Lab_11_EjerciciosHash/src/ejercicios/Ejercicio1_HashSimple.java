package ejercicios;

// Ejercicio 1: Insertar sin colisiones (pero todos colisionan)
public class Ejercicio1_HashSimple {
    public static void main(String[] args) {
        int size = 7;
        Integer[] table = new Integer[size];

        int[] valores = {3, 10, 17, 24}; // Todos colisionan con índice 3

        System.out.println("=== EJERCICIO 1 ===");
        System.out.println("Insertar: 3, 10, 17, 24 con h(x) = x % 7\n");

        for (int x : valores) {
            int index = x % size;
            if (table[index] == null) {
                table[index] = x;
            } else {
                System.out.println("Colisión al insertar " + x + " en índice " + index);
            }
        }

        System.out.println("\nTabla hash final:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + (table[i] != null ? table[i] : "[vacío]"));
        }
        System.out.println("====================\n");
    }
}

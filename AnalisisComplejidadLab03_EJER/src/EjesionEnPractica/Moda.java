package EjesionEnPractica;
import java.util.HashMap;
import java.util.Map;

public class Moda {
    // Función que encuentra el número más frecuente en un vector
    public static int moda(int[] v) {
        Map<Integer, Integer> frecuencia = new HashMap<>(); // Se crea un diccionario para almacenar las frecuencias
        int maxFrecuencia = 0, moda = v[0]; // Se inicializan las variables para la moda y la frecuencia máxima

        // Se recorre el vector y se actualiza el HashMap con la frecuencia de cada número
        for (int num : v) {
            int f = frecuencia.getOrDefault(num, 0) + 1; // Se obtiene la frecuencia actual y se incrementa
            frecuencia.put(num, f); // Se actualiza el HashMap

            // Si la frecuencia actual supera la máxima registrada, se actualiza la moda
            if (f > maxFrecuencia) {
                maxFrecuencia = f;
                moda = num;
            }
        }
        return moda; // Se devuelve el número más frecuente
    }

    public static void main(String[] args) {
        int[] vector = {3, 1, 4, 3, 2, 3, 5, 4, 4, 4, 4}; // Vector de prueba
        System.out.println("Número más frecuente: " + moda(vector)); // Se imprime la moda
    }
}

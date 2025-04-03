package EjesionEnPractica;

public class BM {
    // Función que encuentra el valor máximo en un vector
    public static int BM(int[] v, int n) {
        int m = v[0]; // Se inicializa el máximo con el primer elemento del vector

        // Se recorre el vector desde la segunda posición hasta el final
        for (int i = 1; i < n; i++) { 
            if (v[i] > m) { // Si se encuentra un número mayor, se actualiza el máximo
                m = v[i]; 
            }
        }
        return m; // Se devuelve el valor máximo encontrado
    }

    public static void main(String[] args) {
        int[] vector = {4, 7, 1, 9, 2}; // Vector de prueba
        System.out.println("Máximo valor: " + BM(vector, vector.length)); // Se imprime el resultado
    }
}

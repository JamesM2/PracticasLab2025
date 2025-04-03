package EjesionEnPractica;

public class BM {
    // Funci�n que encuentra el valor m�ximo en un vector
    public static int BM(int[] v, int n) {
        int m = v[0]; // Se inicializa el m�ximo con el primer elemento del vector

        // Se recorre el vector desde la segunda posici�n hasta el final
        for (int i = 1; i < n; i++) { 
            if (v[i] > m) { // Si se encuentra un n�mero mayor, se actualiza el m�ximo
                m = v[i]; 
            }
        }
        return m; // Se devuelve el valor m�ximo encontrado
    }

    public static void main(String[] args) {
        int[] vector = {4, 7, 1, 9, 2}; // Vector de prueba
        System.out.println("M�ximo valor: " + BM(vector, vector.length)); // Se imprime el resultado
    }
}

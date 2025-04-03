package EjesionEnPractica;

public class ConteoI {
    // Función que cuenta cuántos pares de elementos son iguales en un vector
    public static int ConteoI(int[] v, int n) {
        int conteo = 0; // Se inicializa el contador en 0

        // Se utilizan dos bucles anidados para comparar cada par de elementos
        for (int i = 0; i < n - 1; i++) { 
            for (int j = i + 1; j < n; j++) { 
                if (v[i] == v[j]) { // Si los elementos son iguales, se aumenta el contador
                    conteo++; 
                }
            }
        }
        return conteo; // Se devuelve el número total de pares iguales encontrados
    }

    public static void main(String[] args) {
        int[] vector = {3, 5, 3, 2, 5, 5}; // Vector de prueba
        System.out.println("Cantidad de pares iguales: " + ConteoI(vector, vector.length)); // Se imprime el resultado
    }
}

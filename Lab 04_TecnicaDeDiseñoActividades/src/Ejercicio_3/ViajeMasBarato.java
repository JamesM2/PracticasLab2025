package Ejercicio_3;

public class ViajeMasBarato {

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        // Matriz triangular superior de tarifas
        int[][] T = {
            {0, 2, 9, 10},
            {0, 0, 6, 4},
            {0, 0, 0, 8},
            {0, 0, 0, 0}
        };

        // Cantidad de embarcaderos
        int n = T.length;

        // Se crea la matriz C para guardar los costos mínimos
        int[][] C = new int[n][n];

        // Llamada al algoritmo de programación dinámica
        calcularCostosMinimos(T, C, n);

        // Imprimir la matriz de resultados de costos mínimos
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((C[i][j] == Integer.MAX_VALUE ? "∞" : C[i][j]) + "\t");
            }
            System.out.println();
        }

        // Ejemplo: costo mínimo de embarcadero 0 a 3
        System.out.println("\nCosto mínimo de 0 a 3: " + C[0][3]);
    }

    // Algoritmo de programación dinámica para calcular el menor costo
    public static void calcularCostosMinimos(int[][] T, int[][] C, int n) {
        // Recorremos todos los pares (i, j) donde i < j
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    C[i][j] = 0; // Mismo embarcadero, costo 0
                } else {
                    C[i][j] = T[i][j]; // Tomamos el costo directo
                    // Buscamos si existe una ruta más barata haciendo escalas
                    for (int k = i + 1; k < j; k++) {
                        if (T[i][k] != 0 && C[k][j] != Integer.MAX_VALUE) {
                            C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                        }
                    }
                }
            }
        }
    }
}

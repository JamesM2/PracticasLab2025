package ActividadesEnPractica;

public class Ordenar {

    // Procedimiento que ordena un arreglo usando el algoritmo de burbuja.
    // Complejidad: O(n^2), ya que tiene dos bucles anidados.

    public static void ordenar(int[] v, int tamaño) {
        int i, j, aux;  // O(1) - Declaración de variables.
        for (i = 0; i < tamaño - 1; i++) {  // O(n) - Iteración exterior.
            for (j = 0; j < tamaño - 1; j++) {  // O(n) - Iteración interior.
                if (v[j] > v[j + 1]) {  // O(1) - Comparación de los elementos.
                    aux = v[j];  // O(1) - Intercambio de elementos.
                    v[j] = v[j + 1];  // O(1) - Asignación del valor mayor.
                    v[j + 1] = aux;  // O(1) - Asignación del valor menor.
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] v = {5, 3, 8, 6, 2};
        ordenar(v, v.length);  // Llamada al procedimiento para ordenar.
        System.out.println("Arreglo ordenado: ");
        for (int num : v) {
            System.out.print(num + " ");  // Muestra el arreglo ordenado.
        }
    }
}

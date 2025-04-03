package ActividadesEnPractica;

public class Ordenar {

    // Procedimiento que ordena un arreglo usando el algoritmo de burbuja.
    // Complejidad: O(n^2), ya que tiene dos bucles anidados.

    public static void ordenar(int[] v, int tama�o) {
        int i, j, aux;  // O(1) - Declaraci�n de variables.
        for (i = 0; i < tama�o - 1; i++) {  // O(n) - Iteraci�n exterior.
            for (j = 0; j < tama�o - 1; j++) {  // O(n) - Iteraci�n interior.
                if (v[j] > v[j + 1]) {  // O(1) - Comparaci�n de los elementos.
                    aux = v[j];  // O(1) - Intercambio de elementos.
                    v[j] = v[j + 1];  // O(1) - Asignaci�n del valor mayor.
                    v[j + 1] = aux;  // O(1) - Asignaci�n del valor menor.
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

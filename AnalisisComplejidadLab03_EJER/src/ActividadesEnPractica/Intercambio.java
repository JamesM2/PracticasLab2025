package ActividadesEnPractica;

public class Intercambio {

    // Procedimiento que intercambia dos valores enteros.
    // Complejidad: O(1), ya que solo realiza asignaciones constantes.

    public static void intercambia(int[] x, int[] y) {
        int aux;  // O(1) - Declaración de variable auxiliar.
        aux = x[0];  // O(1) - Se almacena el valor de x en aux.
        x[0] = y[0];  // O(1) - Se asigna el valor de y a x.
        y[0] = aux;  // O(1) - Se asigna el valor de aux a y.
    }

    public static void main(String[] args) {
        int[] a = {5};  // Se usa un arreglo para poder modificar el valor.
        int[] b = {10}; // Se usa un arreglo para poder modificar el valor.

        System.out.println("Antes del intercambio: a = " + a[0] + ", b = " + b[0]);
        intercambia(a, b);  // Llamada al procedimiento para intercambiar los valores.
        System.out.println("Después del intercambio: a = " + a[0] + ", b = " + b[0]);
    }
}

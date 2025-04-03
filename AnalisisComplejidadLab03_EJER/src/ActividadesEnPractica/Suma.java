package ActividadesEnPractica;

public class Suma {

    // Funci�n que calcula la suma de los elementos en un arreglo.
    // Complejidad: O(n), ya que recorre el arreglo una vez.

    public static int suma(int[] v, int tama�o) {
        int i, result = 0;  // O(1) - Inicializaci�n de variables.
        for (i = 0; i < tama�o; i++) {  // O(n) - Iteraci�n sobre el arreglo.
            result = result + v[i];  // O(1) - Suma de cada elemento.
        }
        return result;  // O(1) - Retorno de la suma.
    }

    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4, 5};
        System.out.println("La suma es: " + suma(v, v.length));  // Llamada a la funci�n suma.
    }
}

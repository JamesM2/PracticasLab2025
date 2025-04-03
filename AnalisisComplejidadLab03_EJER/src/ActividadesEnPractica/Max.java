package ActividadesEnPractica;

public class Max {

    // Función que obtiene el valor máximo entre dos enteros.
    // Complejidad: O(1), ya que solo realiza comparaciones constantes.

    public static int max(int x, int y) {
        int result;  // O(1) - Declaración de la variable de resultado.
        if (x >= y) {  // O(1) - Comparación entre x y y.
            result = x;  // O(1) - Asignación del valor máximo a result.
        } else {
            result = y;  // O(1) - Asignación del valor máximo a result.
        }
        return result;  // O(1) - Retorno del valor máximo.
    }

    public static void main(String[] args) {
        System.out.println("El valor máximo es: " + max(5, 10));  // Llamada a la función max.
    }
}

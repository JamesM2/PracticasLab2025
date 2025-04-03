package ActividadesEnPractica;

public class Max {

    // Funci�n que obtiene el valor m�ximo entre dos enteros.
    // Complejidad: O(1), ya que solo realiza comparaciones constantes.

    public static int max(int x, int y) {
        int result;  // O(1) - Declaraci�n de la variable de resultado.
        if (x >= y) {  // O(1) - Comparaci�n entre x y y.
            result = x;  // O(1) - Asignaci�n del valor m�ximo a result.
        } else {
            result = y;  // O(1) - Asignaci�n del valor m�ximo a result.
        }
        return result;  // O(1) - Retorno del valor m�ximo.
    }

    public static void main(String[] args) {
        System.out.println("El valor m�ximo es: " + max(5, 10));  // Llamada a la funci�n max.
    }
}

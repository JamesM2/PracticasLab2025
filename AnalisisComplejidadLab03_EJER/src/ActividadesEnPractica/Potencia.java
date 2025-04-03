package ActividadesEnPractica;

public class Potencia {

    // Función que calcula x^y de manera recursiva usando la técnica de potencia rápida.
    // Complejidad: O(log y), ya que divide el exponente por 2 en cada paso.

    public static double potencia(double x, int y) {
        double t;  // O(1) - Declaración de variable auxiliar.
        if (y == 0)  // O(1) - Caso base.
            return 1.0;  // O(1) - Retorna 1 si el exponente es 0.
        if (y % 2 == 1) {  // O(1) - Si el exponente es impar.
            return x * potencia(x, y - 1);  // Llamada recursiva con y-1.
        } else {  // O(1) - Si el exponente es par.
            t = potencia(x, y / 2);  // Llamada recursiva con y/2.
            return t * t;  // O(1) - Multiplicación del resultado recursivo por sí mismo.
        }
    }

    public static void main(String[] args) {
        System.out.println("Resultado de 2^10: " + potencia(2, 10));  // Llamada a la función potencia.
    }
}

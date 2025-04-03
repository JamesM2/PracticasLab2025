package ActividadesEnPractica;

public class Potencia {

    // Funci�n que calcula x^y de manera recursiva usando la t�cnica de potencia r�pida.
    // Complejidad: O(log y), ya que divide el exponente por 2 en cada paso.

    public static double potencia(double x, int y) {
        double t;  // O(1) - Declaraci�n de variable auxiliar.
        if (y == 0)  // O(1) - Caso base.
            return 1.0;  // O(1) - Retorna 1 si el exponente es 0.
        if (y % 2 == 1) {  // O(1) - Si el exponente es impar.
            return x * potencia(x, y - 1);  // Llamada recursiva con y-1.
        } else {  // O(1) - Si el exponente es par.
            t = potencia(x, y / 2);  // Llamada recursiva con y/2.
            return t * t;  // O(1) - Multiplicaci�n del resultado recursivo por s� mismo.
        }
    }

    public static void main(String[] args) {
        System.out.println("Resultado de 2^10: " + potencia(2, 10));  // Llamada a la funci�n potencia.
    }
}

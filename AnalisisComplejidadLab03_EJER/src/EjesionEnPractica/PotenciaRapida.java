package EjesionEnPractica;

public class PotenciaRapida {
    // Función que calcula la potencia de un número usando exponenciación rápida
    public static int potenciaRapida(int x, int y) {
        if (y == 0) return 1; // Caso base: cualquier número elevado a 0 es 1
        if (y % 2 == 0) { 
            int mitad = potenciaRapida(x, y / 2); // Se calcula la mitad de la potencia
            return mitad * mitad; // Si el exponente es par, se multiplica mitad por mitad
        } else {
            return x * potenciaRapida(x, y - 1); // Si el exponente es impar, se multiplica por x y se reduce y en 1
        }
    }

    public static void main(String[] args) {
        System.out.println("Resultado de 2^10: " + potenciaRapida(2, 10)); // Prueba con 2^10
    }
}

package app;

import colecciones.Bolsa;
import modelo.Chocolatina;

public class Principal {
    public static void main(String[] args) {
        System.out.println("=== Bolsa de Chocolatinas ===");

        Bolsa<Chocolatina> bolsaCho = new Bolsa<>();
        Chocolatina c = new Chocolatina("Milka");
        Chocolatina c1 = new Chocolatina("Milka");
        Chocolatina c2 = new Chocolatina("Ferrero");

        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        System.out.println("=== Comparación de Arreglos ===");

        // Arreglos de Chocolatinas para comparación
        Chocolatina[] chocolates1 = { new Chocolatina("Milka"), new Chocolatina("Ferrero") };
        Chocolatina[] chocolates2 = { new Chocolatina("Milka"), new Chocolatina("Ferrero") };
        Chocolatina[] chocolates3 = { new Chocolatina("Milka"), new Chocolatina("Nestlé") };

        // Comparaciones con el método genérico
        if (igualArrays(chocolates1, chocolates2)) {
            System.out.println("chocolates1 es igual a chocolates2");
        }
        if (!igualArrays(chocolates1, chocolates3)) {
            System.out.println("chocolates1 NO es igual a chocolates3");
        }
    }

    // Método genérico para comparar arreglos
    public static <T> boolean igualArrays(T[] x, T[] y) {
        if (x.length != y.length) return false;
        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i])) return false;
        }
        return true;
    }
}

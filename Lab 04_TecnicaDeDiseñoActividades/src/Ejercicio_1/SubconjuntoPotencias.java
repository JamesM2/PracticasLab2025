package Ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class SubconjuntoPotencias {

    // Función para verificar si un número es una potencia de 2
    public static boolean esPotenciaDe2(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    // Función principal para resolver el problema
    public static boolean verificarSubconjunto(int[] arr, int objetivo) {
        // Lista de números que serán seleccionados para el subconjunto
        List<Integer> seleccionado = new ArrayList<>();
        
        // Agregar las potencias de 2 (obligatorias)
        for (int i = 0; i < arr.length; i++) {
            if (esPotenciaDe2(arr[i])) {
                seleccionado.add(arr[i]);
            }
        }

        // Reglas adicionales: verificar múltiplos de 5
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0 && i + 1 < arr.length && arr[i + 1] % 2 != 0) {
                // Si el número es múltiplo de 5 y el siguiente número es impar, no lo agregamos
                continue;
            }
            // Agregar el número al conjunto
            seleccionado.add(arr[i]);
        }

        // Ahora, debemos verificar si podemos sumar los elementos seleccionados para alcanzar el objetivo
        return puedeSumar(seleccionado, objetivo);
    }

    // Función para verificar si se puede formar la suma objetivo con los elementos seleccionados
    public static boolean puedeSumar(List<Integer> seleccionado, int objetivo) {
        // Programación dinámica para verificar si se puede lograr la suma objetivo
        boolean[] dp = new boolean[objetivo + 1];
        dp[0] = true; // Siempre se puede formar la suma 0 (sin seleccionar elementos)

        for (int num : seleccionado) {
            for (int i = objetivo; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[objetivo];
    }

    public static void main(String[] args) {
        // Ejemplo 1: 5 4 8 10 3 5 27
        int[] arr1 = {4, 8, 10, 3, 5};
        int objetivo1 = 27;
        System.out.println("Entrada 1: 5 4 8 10 3 5 27 → Salida: " + verificarSubconjunto(arr1, objetivo1));

        // Ejemplo 2: 5 4 8 10 3 6 27
        int[] arr2 = {4, 8, 10, 3, 6};
        int objetivo2 = 27;
        System.out.println("Entrada 2: 5 4 8 10 3 6 27 → Salida: " + verificarSubconjunto(arr2, objetivo2));

        // Ejemplo 3: 6 2 16 5 7 10 33
        int[] arr3 = {2, 16, 5, 7, 10};
        int objetivo3 = 33;
        System.out.println("Entrada 3: 6 2 16 5 7 10 33 → Salida: " + verificarSubconjunto(arr3, objetivo3));

        // Ejemplo 4: 6 2 16 5 3 10 33
        int[] arr4 = {2, 16, 5, 3, 10};
        int objetivo4 = 33;
        System.out.println("Entrada 4: 6 2 16 5 3 10 33 → Salida: " + verificarSubconjunto(arr4, objetivo4));

        // Ejemplo 5: 4 2 5 1 6 13
        int[] arr5 = {2, 5, 1, 6};
        int objetivo5 = 13;
        System.out.println("Entrada 5: 4 2 5 1 6 13 → Salida: " + verificarSubconjunto(arr5, objetivo5));
    }
}


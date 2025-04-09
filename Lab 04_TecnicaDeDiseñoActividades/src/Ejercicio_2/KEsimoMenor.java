package Ejercicio_2;

import java.util.Arrays;

public class KEsimoMenor {

    // Método principal que se ejecuta al correr el programa
    public static void main(String[] args) {
        // Arreglos de ejemplo con sus respectivos valores de k
        int[] arr1 = {4, 2, 7, 10, 4, 17};
        int[] arr2 = {4, 2, 7, 10, 4, 1, 6};
        int[] arr3 = {4, 2, 7, 1, 4, 6};
        int[] arr4 = {9, 2, 7, 1, 7};

        // Se imprime cada entrada con su k-ésimo elemento más pequeño correspondiente
        System.out.println("Entrada 1: " + Arrays.toString(arr1) + ", 3 → Salida: " + quickSelect(arr1, 0, arr1.length - 1, 3));
        System.out.println("Entrada 2: " + Arrays.toString(arr2) + ", 5 → Salida: " + quickSelect(arr2, 0, arr2.length - 1, 5));
        System.out.println("Entrada 3: " + Arrays.toString(arr3) + ", 1 → Salida: " + quickSelect(arr3, 0, arr3.length - 1, 1));
        System.out.println("Entrada 4: " + Arrays.toString(arr4) + ", 4 → Salida: " + quickSelect(arr4, 0, arr4.length - 1, 4));
    }

    // Algoritmo basado en "Divide y Vencerás" (QuickSelect)
    // Encuentra el k-ésimo menor elemento sin ordenar el arreglo completo
    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left]; // Caso base: solo un elemento

        // Particiona el arreglo y obtiene el índice del pivote
        int pivotIndex = partition(arr, left, right);
        int count = pivotIndex - left + 1; // Elementos en la izquierda del pivote

        if (k == count) {
            // El pivote es el k-ésimo menor
            return arr[pivotIndex];
        } else if (k < count) {
            // Buscar en la mitad izquierda
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            // Buscar en la mitad derecha
            return quickSelect(arr, pivotIndex + 1, right, k - count);
        }
    }

    // Función de partición tipo QuickSort (utiliza el último elemento como pivote)
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Se elige el último como pivote
        int i = left;

        // Reordena los elementos menores que el pivote a la izquierda
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                // Intercambio
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // Coloca el pivote en su posición final
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i; // Retorna el índice del pivote
    }
}

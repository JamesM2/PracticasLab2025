package Ejercicio_2;
import java.util.Random;

public class KEsimoMenor {

    public static void main(String[] args) {
        int[] arreglo = {4, 2, 7, 10, 4, 17};
        int k = 3;

        // Se llama al método quickSelect para encontrar el k-ésimo menor elemento
        int resultado = quickSelect(arreglo, 0, arreglo.length - 1, k - 1);

        System.out.println("El " + k + "° menor elemento es: " + resultado);
    }

    // Algoritmo QuickSelect usando divide y vencerás
    public static int quickSelect(int[] arr, int inicio, int fin, int k) {
        // Caso base: solo queda un elemento en el arreglo
        if (inicio == fin) {
            return arr[inicio];
        }

        // Se elige un índice aleatorio como pivote
        int pivoteIndex = new Random().nextInt(fin - inicio + 1) + inicio;

        // Se reordena el arreglo en torno al pivote
        int pivoteFinal = particionar(arr, inicio, fin, pivoteIndex);

        // Si el índice del pivote es igual a k, se encontró el k-ésimo menor
        if (k == pivoteFinal) {
            return arr[k];
        } 
        // Si k está a la izquierda, buscar en la sublista izquierda
        else if (k < pivoteFinal) {
            return quickSelect(arr, inicio, pivoteFinal - 1, k);
        } 
        // Si k está a la derecha, buscar en la sublista derecha
        else {
            return quickSelect(arr, pivoteFinal + 1, fin, k);
        }
    }

    // Reordena los elementos alrededor del pivote
    public static int particionar(int[] arr, int inicio, int fin, int pivoteIndex) {
        int pivoteValor = arr[pivoteIndex];

        // Mover el pivote al final temporalmente
        swap(arr, pivoteIndex, fin);

        int almacen = inicio;

        // Recorrer desde inicio hasta antes del final
        for (int i = inicio; i < fin; i++) {
            // Si el elemento es menor al pivote, intercambiarlo
            if (arr[i] < pivoteValor) {
                swap(arr, i, almacen);
                almacen++;
            }
        }

        // Colocar el pivote en su posición definitiva
        swap(arr, almacen, fin);

        // Retornar la posición final del pivote
        return almacen;
    }

    // Método auxiliar para intercambiar dos elementos en el arreglo
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

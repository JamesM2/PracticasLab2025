package EjesionEnPractica;

public class MergeSortOptimizado {

    // Umbral a partir del cual se utiliza Merge Sort
    private static final int THRESHOLD = 10;

    // Función principal que implementa Merge Sort optimizado
    public static void mergeSort(int[] arr) {
        mergeSortOptimizado(arr, 0, arr.length - 1);
    }

    // Función recursiva para realizar Merge Sort con la optimización para arreglos pequeños
    private static void mergeSortOptimizado(int[] arr, int left, int right) {
        if (right - left <= THRESHOLD) {
            // Si el tamaño del subarreglo es menor o igual al umbral, usar Insertion Sort
            insertionSort(arr, left, right);
        } else {
            int mid = (left + right) / 2;
            mergeSortOptimizado(arr, left, mid);  // Ordenar la mitad izquierda
            mergeSortOptimizado(arr, mid + 1, right);  // Ordenar la mitad derecha
            merge(arr, left, mid, right);  // Fusionar las dos mitades
        }
    }

    // Implementación de Merge (fusionar dos subarreglos ordenados)
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Implementación de Insertion Sort para arreglos pequeños
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Arreglo original:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("\nArreglo ordenado:");
        printArray(arr);
    }

    // Método auxiliar para imprimir un arreglo
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

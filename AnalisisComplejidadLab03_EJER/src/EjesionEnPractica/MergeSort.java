package EjesionEnPractica;

public class MergeSort {

    // Método principal que ordena el arreglo
    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; // Un solo elemento está ordenado por defecto
        }
        
        int medio = arreglo.length / 2;
        int[] mitadIzquierda = new int[medio];
        int[] mitadDerecha = new int[arreglo.length - medio];
        
        // Copiar los elementos a las mitades
        System.arraycopy(arreglo, 0, mitadIzquierda, 0, medio);
        System.arraycopy(arreglo, medio, mitadDerecha, 0, arreglo.length - medio);
        
        // Ordenar recursivamente ambas mitades
        mergeSort(mitadIzquierda);
        mergeSort(mitadDerecha);
        
        // Fusionar las mitades ordenadas
        merge(arreglo, mitadIzquierda, mitadDerecha);
    }

    // Método que fusiona dos subarreglos ordenados
    private static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Fusionar los subarreglos
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda, si los hay
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }

        // Copiar los elementos restantes de la mitad derecha, si los hay
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] arreglo = {5, 2, 9, 1, 5, 6};
        mergeSort(arreglo);
        
        // Imprimir el arreglo ordenado
        for (int i : arreglo) {
            System.out.print(i + " ");
        }
    }
}

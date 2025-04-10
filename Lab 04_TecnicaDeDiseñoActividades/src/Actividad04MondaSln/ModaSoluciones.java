package Actividad04MondaSln;

public class ModaSoluciones {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 5, 5, 4, 6, 5, 6, 6, 6};

        System.out.println("Moda Solución 1 (frecuencia): " + modaSol1(array));
        System.out.println("Moda Solución 2 (ordenado): " + modaSol2(array.clone()));
        System.out.println("Moda Solución 3 (divide y vencerás): " + Moda3Resolver.moda3(array));
    }

    // Solución 1: calcula frecuencia desde cada posición
    public static int modaSol1(int[] array) {
        int moda = array[0];
        int maxFrec = frecuencia(array, 0, array.length - 1, moda);

        for (int i = 1; i < array.length; i++) {
            int frec = frecuencia(array, i, array.length - 1, array[i]);
            if (frec > maxFrec) {
                maxFrec = frec;
                moda = array[i];
            }
        }
        return moda;
    }

    // Función que cuenta cuántas veces aparece un elemento
    public static int frecuencia(int[] array, int first, int end, int elem) {
        if (first > end) return 0;
        int suma = 0;
        for (int i = first; i <= end; i++) {
            if (array[i] == elem) suma++;
        }
        return suma;
    }

    // Solución 2: requiere ordenar el arreglo y recorrerlo una vez
    public static int modaSol2(int[] array) {
        java.util.Arrays.sort(array);

        int moda = array[0];
        int maxCount = 1, count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    moda = array[i];
                }
            } else {
                count = 1;
            }
        }
        return moda;
    }
}

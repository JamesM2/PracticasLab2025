package Actividad04MondaSln;

public class ModaSoluciones {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 5, 5, 4, 6, 5, 6, 6, 6};

        System.out.println("Moda Soluci�n 1 (frecuencia): " + modaSol1(array));
        System.out.println("Moda Soluci�n 2 (ordenado): " + modaSol2(array.clone()));
        System.out.println("Moda Soluci�n 3 (divide y vencer�s): " + Moda3Resolver.moda3(array));
    }

    // Soluci�n 1: calcula frecuencia desde cada posici�n
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

    // Funci�n que cuenta cu�ntas veces aparece un elemento
    public static int frecuencia(int[] array, int first, int end, int elem) {
        if (first > end) return 0;
        int suma = 0;
        for (int i = first; i <= end; i++) {
            if (array[i] == elem) suma++;
        }
        return suma;
    }

    // Soluci�n 2: requiere ordenar el arreglo y recorrerlo una vez
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

package Actividad04moda;

public class ModaArray {

    // Método que calcula la moda en un arreglo ordenado
    public static int moda2(int[] array) {
        int first = 1;  // Apuntador a la segunda posición del arreglo
        int p = 0;      // Apuntador al primer elemento del arreglo
        int end = array.length - 1;  // Última posición del arreglo
        int moda = array[0];  // Inicializa la moda con el primer elemento
        int frec = 1;   // Frecuencia del primer elemento es 1
        int maxfrec = 0;  // La máxima frecuencia encontrada hasta el momento

        // Recorre el arreglo desde el segundo elemento hasta el final
        while (first <= end) {
            if (array[p] == array[first]) {  // Si el elemento actual es igual al anterior
                frec++;  // Aumenta la frecuencia
                first++; // Avanza al siguiente elemento
            } else {  // Si el elemento es diferente
                if (frec > maxfrec) {  // Si la frecuencia actual es mayor que la máxima
                    maxfrec = frec;  // Actualiza la máxima frecuencia
                    moda = array[p];  // Actualiza la moda
                }
                p = first;  // Mueve el apuntador 'p' al nuevo elemento
                first = p + 1;  // Establece el siguiente primer elemento
                frec = 1;   // Reinicia la frecuencia a 1
            }
        }

        // Verifica si la última frecuencia es la mayor
        if (frec > maxfrec) {
            maxfrec = frec;
            moda = array[p];
        }

        return moda;  // Retorna la moda
    }
}

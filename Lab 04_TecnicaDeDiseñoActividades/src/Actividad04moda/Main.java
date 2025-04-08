package Actividad04moda;
public class Main {
    public static void main(String[] args) {
        // Ejemplo de arreglo de datos
        int[] arreglo = {1, 2, 2, 3, 3, 3, 4, 4, 5};

        // Llamar a la función moda3 para calcular la moda
        int moda = ModaArray.moda3(arreglo, 0, arreglo.length - 1);

        // Mostrar el resultado de la moda
        System.out.println("La moda del arreglo es: " + moda);
    }
}

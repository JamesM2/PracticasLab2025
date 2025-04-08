package Actividad05NaiveSolution;
public class DpSolution {

    // Método de programación dinámica para obtener el valor máximo
    static int getValue(int[] values, int rodLength) {
        // Creamos una tabla para almacenar los resultados de subproblemas
        int[] subSolutions = new int[rodLength + 1];

        // Calculamos los valores máximos para todas las longitudes de la varilla
        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1; // Variable para almacenar el valor máximo

            // Para cada posible corte en la posición j
            for (int j = 0; j < i; j++) {
                
            	
            	// Calculamos el valor máximo considerando el corte en la posición j
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);

                // Imprime el detalle de la evaluación en cada paso
                System.out.println("--------------------------------------------------");
                System.out.println("Evaluando longitud " + i + ": Corte en la posición " + (j+1));
                System.out.println("  Precio de la pieza: " + values[j]);
                System.out.println("  Subsolución para el resto: " + subSolutions[i - j - 1]);
                System.out.println("  Valor temporal máximo: " + tmpMax);
                System.out.println("--------------------------------------------------");
            }

            
            
            // Guardamos el valor máximo obtenido para una varilla de longitud i
            subSolutions[i] = tmpMax;

            
            // Imprime el valor almacenado para la longitud i
            System.out.println("Valor máximo para longitud " + i + " almacenado: " + subSolutions[i]);
            System.out.println("--------------------------------------------------");
        }

       
        // Devolvemos el valor máximo para la varilla completa
        return subSolutions[rodLength];
    }

    public static void main(String[] args) {
        
    	// Arreglo con los precios de las piezas de longitud 1 a n
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length; // Longitud de la varilla

        
        // Imprime el valor máximo calculado con programación dinámica
        System.out.println("--------------------------------------------------");
        System.out.println("Solución con programación dinámica:");
        System.out.println("--------------------------------------------------");
        System.out.println("El valor máximo obtenido es: " + getValue(values, rodLength));
        System.out.println("--------------------------------------------------");
    }
}

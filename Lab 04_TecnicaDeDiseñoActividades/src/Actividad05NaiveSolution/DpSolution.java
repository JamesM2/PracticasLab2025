package Actividad05NaiveSolution;
public class DpSolution {

    // M�todo de programaci�n din�mica para obtener el valor m�ximo
    static int getValue(int[] values, int rodLength) {
        // Creamos una tabla para almacenar los resultados de subproblemas
        int[] subSolutions = new int[rodLength + 1];

        // Calculamos los valores m�ximos para todas las longitudes de la varilla
        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1; // Variable para almacenar el valor m�ximo

            // Para cada posible corte en la posici�n j
            for (int j = 0; j < i; j++) {
                
            	
            	// Calculamos el valor m�ximo considerando el corte en la posici�n j
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);

                // Imprime el detalle de la evaluaci�n en cada paso
                System.out.println("--------------------------------------------------");
                System.out.println("Evaluando longitud " + i + ": Corte en la posici�n " + (j+1));
                System.out.println("  Precio de la pieza: " + values[j]);
                System.out.println("  Subsoluci�n para el resto: " + subSolutions[i - j - 1]);
                System.out.println("  Valor temporal m�ximo: " + tmpMax);
                System.out.println("--------------------------------------------------");
            }

            
            
            // Guardamos el valor m�ximo obtenido para una varilla de longitud i
            subSolutions[i] = tmpMax;

            
            // Imprime el valor almacenado para la longitud i
            System.out.println("Valor m�ximo para longitud " + i + " almacenado: " + subSolutions[i]);
            System.out.println("--------------------------------------------------");
        }

       
        // Devolvemos el valor m�ximo para la varilla completa
        return subSolutions[rodLength];
    }

    public static void main(String[] args) {
        
    	// Arreglo con los precios de las piezas de longitud 1 a n
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length; // Longitud de la varilla

        
        // Imprime el valor m�ximo calculado con programaci�n din�mica
        System.out.println("--------------------------------------------------");
        System.out.println("Soluci�n con programaci�n din�mica:");
        System.out.println("--------------------------------------------------");
        System.out.println("El valor m�ximo obtenido es: " + getValue(values, rodLength));
        System.out.println("--------------------------------------------------");
    }
}

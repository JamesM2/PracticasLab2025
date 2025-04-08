package Actividad05NaiveSolution;
public class NaiveSolution {

    // M�todo recursivo para obtener el valor m�ximo al cortar la varilla
    static int getValue(int[] values, int length) {
       
        	
    	// Caso base: si la longitud de la varilla es 0, no se puede cortar
        if (length <= 0)
            return 0;

               
        int tmpMax = -1; // Variable para almacenar el valor m�ximo encontrado

        // Para cada posible corte (de tama�o 1 a n), calcula el valor m�ximo
        for (int i = 0; i < length; i++) {
            
        	       	
        	     	
        	// Compara el valor m�ximo de cortar en la posici�n i y resolver el problema para el resto
            tmpMax = Math.max(tmpMax, values[i] + getValue(values, length - i - 1));

                      
            // Imprime el detalle de la soluci�n en cada paso
            System.out.println("--------------------------------------------------");
            System.out.println("Evaluando corte en la posici�n " + (i+1) + ":");
            System.out.println("  Precio de la pieza: " + values[i]);
            System.out.println("  Valor restante: " + getValue(values, length - i - 1));
            System.out.println("  Valor temporal m�ximo: " + tmpMax);
            System.out.println("--------------------------------------------------");
        }

       
        return tmpMax; // Devuelve el valor m�ximo encontrado
    }

   
    public static void main(String[] args) {
        
    	
    	// Arreglo que contiene los precios de las piezas de longitud 1, 2, ..., n
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length; // Longitud de la varilla es igual al tama�o del arreglo

                
        // Imprime el valor m�ximo que se puede obtener cortando la varilla
        System.out.println("--------------------------------------------------");
        System.out.println("Soluci�n recursiva (sin programaci�n din�mica):");
        System.out.println("--------------------------------------------------");
        System.out.println("El valor m�ximo obtenido es: " + getValue(values, rodLength));
        System.out.println("--------------------------------------------------");
    }
}

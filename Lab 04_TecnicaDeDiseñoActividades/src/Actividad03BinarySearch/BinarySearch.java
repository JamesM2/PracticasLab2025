package Actividad03BinarySearch;

public class BinarySearch {
	    // Método recursivo para realizar la búsqueda binaria
	    public int binarySearch(int[] arr, int lo, int hi, int x) {
	       

	        if (hi >= lo) {
	            int mid = lo + (hi - lo) / 2;
	            System.out.println(" Posicion: " + mid + " (valor en medio: " + arr[mid] + ")");

	            if (arr[mid] == x) {
	                
	                return mid;
	            }

	            if (arr[mid] > x) {
	                System.out.println("   El valor buscado es menor que " + arr[mid] + ", buscando en la mitad izquierda");
	                return binarySearch(arr, lo, mid - 1, x);
	            }

	            System.out.println("   El valor buscado es mayor que " + arr[mid] + ", buscando en la mitad derecha");
	            return binarySearch(arr, mid + 1, hi, x);
	        }

	        System.out.println("   Elemento no encontrado en este intervalo.");
	        return -1;
	    }

	    public static void main(String[] args) {
	        BinarySearch buscador = new BinarySearch();

	        // Arreglo ordenado para aplicar búsqueda binaria
	        int[] datos = {1, 3, 5, 7, 9, 11, 13, 15};

	        // Valor que se desea buscar
	        int objetivo = 7;

	        // Mostrar el arreglo
	        System.out.print("Arreglo ordenado: ");
	        for (int valor : datos) {
	            System.out.print(valor + " ");
	        }
	        System.out.println("\nValor a buscar: " + objetivo);

	        // Realizar la búsqueda binaria
	        int resultado = buscador.binarySearch(datos, 0, datos.length - 1, objetivo);

	        // Mostrar resultado
	        if (resultado == -1) {
	            System.out.println("\nResultado: El valor " + objetivo + " no se encuentra en el arreglo.");
	        } else {
	            System.out.println("\nResultado: El valor " + objetivo + " se encuentra en la posicion " + resultado + ".");
	        }
	    }
	    
	}

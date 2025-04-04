package Actividad01Hanoi;

public class Hanoi {
    public static void main(String[] args) {
        int n = 3; // Cambiar el número de discos según se necesite
        torresHanoi(n, 1, 2, 3);
    }

    // Método recursivo para resolver las Torres de Hanoi
    public static void torresHanoi(int discos, int origen, int auxiliar, int destino) {
        // Caso base: si solo hay un disco, moverlo directamente
        if (discos == 1) {
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
        } else {
            // Paso 1: Mover n-1 discos de origen a auxiliar
            torresHanoi(discos - 1, origen, destino, auxiliar);
            
            // Paso 2: Mover el disco más grande de origen a destino
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
            
            // Paso 3: Mover los n-1 discos de auxiliar a destino
            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
    }
}

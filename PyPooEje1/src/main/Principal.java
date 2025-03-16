package main;

import model.*;
import java.util.Scanner;

// Ejecuta el programa y gestiona la entrada de datos
public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContainerRect contenedor = new ContainerRect(10); // Contenedor con capacidad para 10 rectángulos

        // Se solicita al usuario que ingrese 3 rectángulos
        for (int i = 0; i < 3; i++) {  
            System.out.println("Ingrese una esquina del rectángulo " + (i + 1) + " (x y):");
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();

            System.out.println("Ingrese la esquina opuesta del rectángulo " + (i + 1) + " (x y):");
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            Coordenada c1 = new Coordenada(x1, y1);
            Coordenada c2 = new Coordenada(x2, y2);
            Rectangulo r = new Rectangulo(c1, c2);

            contenedor.addRectangulo(r);
        }

        // Se muestra la lista de rectángulos almacenados
        System.out.println("\nLista de Rectángulos Almacenados:");
        System.out.println(contenedor);

        sc.close();
    }
}

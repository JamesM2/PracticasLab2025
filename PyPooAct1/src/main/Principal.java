package main;
import model.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese coordenadas del 1er rectángulo:");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();

        System.out.println("Ingrese coordenadas del 2do rectángulo:");
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();
        double x4 = sc.nextDouble(), y4 = sc.nextDouble();

        Rectangulo A = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        Rectangulo B = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));

        System.out.println(A);
        System.out.println(B);

        if (Verificador.seSobreponen(A, B)) {
            double areaSobreposicion = Verificador.calcularAreaSobreposicion(A, B);
            System.out.println("Los rectángulos se sobreponen. Área de sobreposición = " + areaSobreposicion);
        } else if (Verificador.estanJuntos(A, B)) {
            System.out.println("Los rectángulos están juntos.");
        } else {
            System.out.println("Los rectángulos son disjuntos.");
        }

        sc.close();
    }
}

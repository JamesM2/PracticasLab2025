package InterfacesClasesGenericas;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean esDouble = false;

        System.out.println("Seleccione el tipo de datos:");
        System.out.println("1. Enteros");
        System.out.println("2. Decimales (Double)");
        int tipoDato = scanner.nextInt();

        Operable<Integer> operInt = new OperacionesMatInteger();
        Operable<Double> operDouble = new OperacionesMatDouble();
        
        if (tipoDato == 2) {
            esDouble = true;
        }

        do {
            System.out.println("\nMenú de Operaciones:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Ingrese el primer número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double num2 = scanner.nextDouble();

                if (esDouble) {
                    switch (opcion) {
                        case 1 -> System.out.println("Resultado: " + operDouble.suma(num1, num2));
                        case 2 -> System.out.println("Resultado: " + operDouble.resta(num1, num2));
                        case 3 -> System.out.println("Resultado: " + operDouble.producto(num1, num2));
                        case 4 -> System.out.println("Resultado: " + operDouble.division(num1, num2));
                        case 5 -> System.out.println("Resultado: " + operDouble.potencia(num1, num2));
                    }
                } else {
                    switch (opcion) {
                        case 1 -> System.out.println("Resultado: " + operInt.suma((int) num1, (int) num2));
                        case 2 -> System.out.println("Resultado: " + operInt.resta((int) num1, (int) num2));
                        case 3 -> System.out.println("Resultado: " + operInt.producto((int) num1, (int) num2));
                        case 4 -> System.out.println("Resultado: " + operInt.division((int) num1, (int) num2));
                        case 5 -> System.out.println("Resultado: " + operInt.potencia((int) num1, (int) num2));
                    }
                }
            } else if (opcion == 6 || opcion == 7) {
                System.out.print("Ingrese el número: ");
                double num = scanner.nextDouble();

                if (esDouble) {
                    if (opcion == 6) System.out.println("Resultado: " + operDouble.raizCuadrada(num));
                    if (opcion == 7) System.out.println("Resultado: " + operDouble.raizCubica(num));
                } else {
                    if (opcion == 6) System.out.println("Resultado: " + operInt.raizCuadrada((int) num));
                    if (opcion == 7) System.out.println("Resultado: " + operInt.raizCubica((int) num));
                }
            }

        } while (opcion != 8);

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}

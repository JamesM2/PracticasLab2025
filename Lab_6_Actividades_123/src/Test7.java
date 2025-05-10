import ejercicio4.Application;

public class Test7 {
    public static void main(String[] args) {
        String[] pruebas = {
            "()()()[()]()",
            "((()))[]",
            "([])[](",
            "([{)]}",
            "[",
            "[][][]{{{}}}"
        };

        for (String cadena : pruebas) {
            boolean resultado = Application.symbolBalancing(cadena);
            System.out.println("Cadena: " + cadena + " => " + resultado);
        }
    }
}

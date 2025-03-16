package model;

public class Verificador {

    public static boolean seSobreponen(Rectangulo a, Rectangulo b) {
        return !(a.getEsquina1().getX() > b.getEsquina2().getX() ||
                 a.getEsquina2().getX() < b.getEsquina1().getX() ||
                 a.getEsquina1().getY() > b.getEsquina2().getY() ||
                 a.getEsquina2().getY() < b.getEsquina1().getY());
    }

    public static boolean estanJuntos(Rectangulo a, Rectangulo b) {
        return (a.getEsquina1().getX() == b.getEsquina2().getX() ||
                a.getEsquina2().getX() == b.getEsquina1().getX() ||
                a.getEsquina1().getY() == b.getEsquina2().getY() ||
                a.getEsquina2().getY() == b.getEsquina1().getY());
    }

    public static boolean sonDisjuntos(Rectangulo a, Rectangulo b) {
        return !seSobreponen(a, b) && !estanJuntos(a, b);
    }

    // Método que calcula el área de sobreposición entre dos rectángulos
    public static double calcularAreaSobreposicion(Rectangulo a, Rectangulo b) {
        if (!seSobreponen(a, b)) return 0;

        double xIzq = Math.max(a.getEsquina1().getX(), b.getEsquina1().getX());
        double xDer = Math.min(a.getEsquina2().getX(), b.getEsquina2().getX());
        double yInf = Math.max(a.getEsquina1().getY(), b.getEsquina1().getY());
        double ySup = Math.min(a.getEsquina2().getY(), b.getEsquina2().getY());

        double base = Math.abs(xDer - xIzq);
        double altura = Math.abs(ySup - yInf);

        return base * altura;
    }
}

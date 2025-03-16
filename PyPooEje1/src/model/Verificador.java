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
}

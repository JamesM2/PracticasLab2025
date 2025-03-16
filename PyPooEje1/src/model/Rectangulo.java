package model;

// Representa un rectángulo definido por dos coordenadas
public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = c1;
        this.esquina2 = c2;
    }

    public void setEsquina1(Coordenada c) {
        this.esquina1 = c;
    }

    public void setEsquina2(Coordenada c) {
        this.esquina2 = c;
    }

    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    // Calcula el área del rectángulo
    public double calcularArea() {
        double base = Math.abs(esquina1.getX() - esquina2.getX());
        double altura = Math.abs(esquina1.getY() - esquina2.getY());
        return base * altura;
    }

    public String toString() {
        return "(" + esquina1.toString() + ", " + esquina2.toString() + ")";
    }
}

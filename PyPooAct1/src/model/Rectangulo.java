package model;

public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = c1;
        this.esquina2 = c2;}

    // Métodos setter
    public void setEsquina1(Coordenada c) {
        this.esquina1 = c;}

    public void setEsquina2(Coordenada c) {
        this.esquina2 = c;}

    // Métodos getter
    public Coordenada getEsquina1() {
        return esquina1;}

    public Coordenada getEsquina2() {
        return esquina2;}

    // Método para calcular el área del rectángulo
    public double calcularArea() {
        double base = Math.abs(esquina2.getX() - esquina1.getX());
        double altura = Math.abs(esquina2.getY() - esquina1.getY());
        return base * altura;}

    // Método toString
    @Override
    public String toString() {
        return "Rectángulo = (" + esquina1.toString() + ", " + esquina2.toString() + ")";}
}

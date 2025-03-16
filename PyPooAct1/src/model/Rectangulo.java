package model;

public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = c1;
        this.esquina2 = c2;}

    // M�todos setter
    public void setEsquina1(Coordenada c) {
        this.esquina1 = c;}

    public void setEsquina2(Coordenada c) {
        this.esquina2 = c;}

    // M�todos getter
    public Coordenada getEsquina1() {
        return esquina1;}

    public Coordenada getEsquina2() {
        return esquina2;}

    // M�todo para calcular el �rea del rect�ngulo
    public double calcularArea() {
        double base = Math.abs(esquina2.getX() - esquina1.getX());
        double altura = Math.abs(esquina2.getY() - esquina1.getY());
        return base * altura;}

    // M�todo toString
    @Override
    public String toString() {
        return "Rect�ngulo = (" + esquina1.toString() + ", " + esquina2.toString() + ")";}
}

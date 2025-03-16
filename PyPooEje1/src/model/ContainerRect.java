package model;

// Almacena rectángulos y sus datos asociados
public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    private int numRec = 0;

    public ContainerRect(int n) {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    // Agrega un rectángulo al contenedor si hay espacio disponible
    public boolean addRectangulo(Rectangulo r) {
        if (numRec >= n) {
            System.out.println("No se puede agregar más rectángulos");
            return false;
        }
        rectangulos[numRec] = r; // Almacena el rectángulo
        distancias[numRec] = r.getEsquina1().distancia(r.getEsquina2()); // Calcula la distancia
        areas[numRec] = r.calcularArea(); // Calcula el área
        numRec++;
        return true;
    }

    // Devuelve una representación de los rectángulos almacenados
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectángulo\tCoordenadas\t\tDistancia\tÁrea\n");
        for (int i = 0; i < numRec; i++) {
            sb.append((i + 1) + "\t" + rectangulos[i].toString() + "\t" 
                      + String.format("%.3f", distancias[i]) + "\t" 
                      + String.format("%.2f", areas[i]) + "\n");
        }
        return sb.toString();
    }
}

package comejemplobolsa;

/**
 * Clase que representa una golosina con un nombre y un peso específico.
 */
public class Golosina {
    private String nombre; // Nombre de la golosina
    private double peso; // Peso de la golosina en gramos

    /**
     * Constructor que inicializa la golosina con su nombre y peso.
     * 
     * @param nombre Nombre de la golosina.
     * @param peso Peso de la golosina en gramos.
     */
    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * Obtiene el nombre de la golosina.
     * 
     * @return Nombre de la golosina.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para la golosina.
     * 
     * @param nombre Nombre de la nueva golosina.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el peso de la golosina.
     * 
     * @return Peso de la golosina en gramos.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece un nuevo peso para la golosina.
     * 
     * @param peso Nuevo peso en gramos.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Representación en cadena del objeto Golosina.
     * 
     * @return Cadena con la información de la golosina.
     */
    @Override
    public String toString() {
        return "Golosina{" + "nombre='" + nombre + '\'' + ", peso=" + peso + "g}";
    }
}

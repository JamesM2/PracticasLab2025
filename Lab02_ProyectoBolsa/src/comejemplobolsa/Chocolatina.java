package comejemplobolsa;

/**
 * Clase que representa una chocolatina con una marca específica.
 */
public class Chocolatina {
    private String marca; // Nombre de la marca de la chocolatina

    /**
     * Constructor que inicializa la chocolatina con su marca.
     * 
     * @param marca Nombre de la marca de la chocolatina.
     */
    public Chocolatina(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la marca de la chocolatina.
     * 
     * @return Nombre de la marca.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece una nueva marca para la chocolatina.
     * 
     * @param marca Nombre de la nueva marca.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Representación en cadena del objeto Chocolatina.
     * 
     * @return Cadena con la información de la chocolatina.
     */
    @Override
    public String toString() {
        return "Chocolatina{" + "marca='" + marca + '\'' + '}';
    }
}

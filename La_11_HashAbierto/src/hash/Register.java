package hash;

// Clase que representa un registro con clave y nombre
public class Register {
    private int key;
    private String name;

    // Constructor para inicializar clave y nombre
    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    // Devuelve la clave del registro
    public int getKey() {
        return key;
    }

    // Devuelve el nombre del registro
    public String getName() {
        return name;
    }

    // Representación en texto del registro
    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}

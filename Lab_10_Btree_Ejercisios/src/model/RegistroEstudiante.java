package model;

// Clase que representa a un estudiante con código y nombre
public class RegistroEstudiante implements Comparable<RegistroEstudiante> {
    private int codigo;
    private String nombre;

    public RegistroEstudiante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    // Muestra el estudiante como texto legible
    public String toString() {
        return codigo + " - " + nombre;
    }

    // Compara por código para el Árbol B
    public int compareTo(RegistroEstudiante otro) {
        return Integer.compare(this.codigo, otro.codigo);
    }
}

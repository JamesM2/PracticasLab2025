package ejercicios;

// Clase b�sica para almacenar clave y nombre
public class Register {
    private int key;
    private String name;

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}

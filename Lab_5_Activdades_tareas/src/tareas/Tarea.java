package tareas;

// Clase que representa una tarea con título y prioridad
public class Tarea {
    private String titulo; // Título de la tarea
    private int prioridad; // Nivel de prioridad

    // Constructor de la tarea
    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    // Getter para el título
    public String getTitulo() {
        return titulo;
    }

    // Getter para la prioridad
    public int getPrioridad() {
        return prioridad;
    }

    // Para mostrar la tarea como texto
    @Override
    public String toString() {
        return "Tarea: " + titulo + " | Prioridad: " + prioridad;
    }

    // Para comparar si dos tareas son iguales
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tarea) {
            Tarea t = (Tarea) obj;
            return this.titulo.equals(t.titulo) && this.prioridad == t.prioridad;
        }
        return false;
    }
}

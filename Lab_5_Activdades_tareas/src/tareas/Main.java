package tareas;

public class Main {
    public static void main(String[] args) {
        // Crear el gestor
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        // Agregar tareas
        gestor.agregarTarea(new Tarea("Estudiar", 3));
        gestor.agregarTarea(new Tarea("Lavar ropa", 1));
        gestor.agregarTarea(new Tarea("Hacer tarea", 5));

        // Imprimir tareas
        System.out.println("TAREAS:");
        gestor.imprimirTareas();

        // Eliminar una tarea
        gestor.eliminarTarea(new Tarea("Lavar ropa", 1));

        // Verificar tarea
        System.out.println("\n¿Existe 'Estudiar'?");
        System.out.println(gestor.contieneTarea(new Tarea("Estudiar", 3)) ? "Sí existe" : "No existe");

        // Invertir e imprimir
        gestor.invertirTareas();
        System.out.println("\nTAREAS INVERTIDAS:");
        gestor.imprimirTareas();

        // Tarea con mayor prioridad
        System.out.println("\nTAREA MÁS PRIORITARIA:");
        System.out.println(gestor.obtenerTareaMasPrioritaria());

        // Completar una tarea
        gestor.completarTarea(new Tarea("Hacer tarea", 5));

        // Mostrar tareas restantes y completadas
        System.out.println("\nTAREAS RESTANTES:");
        gestor.imprimirTareas();

        System.out.println("\nTAREAS COMPLETADAS:");
        gestor.imprimirTareasCompletadas();
    }
}

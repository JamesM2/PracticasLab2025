package hash;

// Clase de prueba actualizada con los valores solicitados por el enunciado
public class TestHashO {
    public static void main(String[] args) {
        HashO hashTable = new HashO(7); // Tamaño pequeño para provocar colisiones

        // Insertar los valores: 34, 3, 7, 30, 11, 8, 7, 23, 41, 16, 34 (todos con nombres distintos)
        Register[] registros = {
            new Register(34, "Ana"),   //vaklor clave
            new Register(3, "Luis"),
            new Register(7, "Carlos"), //valor clave 
            new Register(30, "Marta"),
            new Register(11, "Juan"),
            new Register(8, "Elena"),
            new Register(7, "Pedro"),  // mismo valor clave, distinto nombre
            new Register(23, "Sofía"),
            new Register(41, "Lucas"),
            new Register(16, "Clara"),
            new Register(34, "David") // misma clave, distinto nombre
        };

        // Insertar todos los registros en la tabla
        for (Register reg : registros) {
            hashTable.insert(reg);
        }

        // Mostrar tabla después de insertar
        System.out.println("\nTabla después de insertar:");
        hashTable.printTable();

        // Eliminar clave 30
        System.out.println("\nEliminando clave 30...");
        hashTable.delete(30);

        // Mostrar tabla después de eliminación
        System.out.println("\nTabla después de eliminar clave 30:");
        hashTable.printTable();

        // Buscar clave 23
        System.out.println("\nBuscando clave 23...");
        Register resultado = hashTable.search(23);
        if (resultado != null) {
            System.out.println("Encontrado: " + resultado);
        } else {
            System.out.println("No se encontró la clave 23.");
        }
    }
}

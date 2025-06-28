package ejercicios;

// Ejercicio 4: Eliminación lógica en hash cerrado
public class Ejercicio4_EliminacionHashCerrado {
    static class Element {
        Register reg;
        boolean isAvailable;

        public Element() {
            this.reg = null;
            this.isAvailable = true;
        }
    }

    static class HashC {
        private Element[] table;
        private int size;

        public HashC(int size) {
            this.size = size;
            this.table = new Element[size];
            for (int i = 0; i < size; i++) {
                table[i] = new Element();
            }
        }

        private int hash(int key) {
            return key % size;
        }

        public void insert(Register reg) {
            int index = hash(reg.getKey());
            while (!table[index].isAvailable && table[index].reg != null) {
                index = (index + 1) % size;
            }
            table[index].reg = reg;
            table[index].isAvailable = false;
        }

        public Register search(int key) {
            int index = hash(key);
            int start = index;

            while (!table[index].isAvailable) {
                if (table[index].reg != null && table[index].reg.getKey() == key) {
                    return table[index].reg;
                }
                index = (index + 1) % size;
                if (index == start) break;
            }
            return null;
        }

        public void delete(int key) {
            int index = hash(key);
            int start = index;

            while (!table[index].isAvailable) {
                if (table[index].reg != null && table[index].reg.getKey() == key) {
                    table[index].isAvailable = true;
                    return;
                }
                index = (index + 1) % size;
                if (index == start) break;
            }
        }

        public void printTable() {
            for (int i = 0; i < size; i++) {
                if (table[i].reg != null && !table[i].isAvailable) {
                    System.out.println(i + " -> " + table[i].reg);
                } else {
                    System.out.println(i + " -> [vacío]");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 4 ===");
        System.out.println("Eliminación lógica en hash cerrado\n");

        HashC tabla = new HashC(7);
        tabla.insert(new Register(5, "Uno"));
        tabla.insert(new Register(12, "Dos"));
        tabla.insert(new Register(19, "Tres"));

        System.out.println("Antes de eliminar:");
        tabla.printTable();

        System.out.println("\nEliminando clave 12...");
        tabla.delete(12);

        System.out.println("\nDespués de eliminar:");
        tabla.printTable();

        System.out.println("\nBuscando clave 19:");
        Register r = tabla.search(19);
        System.out.println(r != null ? "Encontrado: " + r.getName() : "No encontrado");

        System.out.println("\nDiferencia entre eliminación lógica y física:");
        System.out.println("- Lógica: se marca como disponible pero el objeto queda.");
        System.out.println("- Física: se borra completamente el contenido de la celda.");
        System.out.println("====================\n");
    }
}

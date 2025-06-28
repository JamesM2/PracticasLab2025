package ejercicios;

import java.util.LinkedList;

// Ejercicio 3: Hash abierto con encadenamiento
public class Ejercicio3_HashAbierto {
    static class HashO {
        private LinkedList<Register>[] table;
        private int size;

        public HashO(int size) {
            this.size = size;
            this.table = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int hash(int key) {
            return key % size;
        }

        public void insert(Register reg) {
            int index = hash(reg.getKey());
            table[index].add(reg);
        }

        public Register search(int key) {
            int index = hash(key);
            for (Register reg : table[index]) {
                if (reg.getKey() == key) {
                    return reg;
                }
            }
            return null;
        }

        public void printTable() {
            for (int i = 0; i < size; i++) {
                System.out.print(i + " -> ");
                if (table[i].isEmpty()) {
                    System.out.println("[vacío]");
                } else {
                    for (Register reg : table[i]) {
                        System.out.print(reg + " -> ");
                    }
                    System.out.println("null");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 3 ===");
        System.out.println("Hash abierto con encadenamiento\n");

        HashO tabla = new HashO(5);

        tabla.insert(new Register(10, "Juan"));
        tabla.insert(new Register(15, "Ana"));
        tabla.insert(new Register(20, "Luis"));
        tabla.insert(new Register(25, "Rosa"));

        System.out.println("Tabla hash:");
        tabla.printTable();

        System.out.println("\nBuscando clave 20:");
        Register r1 = tabla.search(20);
        System.out.println(r1 != null ? "Encontrado: " + r1.getName() : "No encontrado");

        System.out.println("Buscando clave 30:");
        Register r2 = tabla.search(30);
        System.out.println(r2 != null ? "Encontrado: " + r2.getName() : "No encontrado");
        System.out.println("====================\n");
    }
}

package ejercicios;

// Ejercicio 2: Hash cerrado con sondeo lineal
public class Ejercicio2_HashCerrado {
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
            int attempts = 0;

            while (!table[index].isAvailable && table[index].reg != null) {
                index = (index + 1) % size;
                attempts++;
                if (attempts >= size) {
                    System.out.println("Tabla llena, no se puede insertar " + reg.getKey());
                    return;
                }
            }

            table[index].reg = reg;
            table[index].isAvailable = false;
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
        System.out.println("=== EJERCICIO 2 ===");
        System.out.println("Hash cerrado con sondeo lineal - Inserción paso a paso\n");

        HashC tabla = new HashC(6);
        int[] claves = {12, 18, 24, 30};

        for (int clave : claves) {
            System.out.println("Insertando " + clave + "...");
            tabla.insert(new Register(clave, "valor" + clave));
            tabla.printTable();
            System.out.println();
        }

        System.out.println("Colisiones resueltas por sondeo lineal.");
        System.out.println("====================\n");
    }
}

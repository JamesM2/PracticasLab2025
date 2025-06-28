package hash;

import java.util.LinkedList;

public class HashO {
    private LinkedList<Register>[] table; // Arreglo de listas
    private int size;

    // Constructor que inicializa la tabla y las listas vac�as
    public HashO(int size) {
        this.size = size;
        this.table = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Funci�n hash que determina la posici�n
    private int hash(int key) {
        return key % size;
    }

    // Inserta un registro en la lista correspondiente
    public void insert(Register reg) {
        int index = hash(reg.getKey());
        table[index].add(reg);
    }

    // Busca un registro por su clave
    public Register search(int key) {
        int index = hash(key);
        for (Register reg : table[index]) {
            if (reg.getKey() == key) {
                return reg;
            }
        }
        return null;
    }

    // Elimina un registro por su clave
    public void delete(int key) {
        int index = hash(key);
        for (Register reg : table[index]) {
            if (reg.getKey() == key) {
                table[index].remove(reg);
                return;
            }
        }
        System.out.println("No se encontr� la clave para eliminar: " + key);
    }

    // Muestra el contenido de la tabla hash
    public void printTable() {
        System.out.println("Estado actual de la tabla:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " -> ");
            if (table[i].isEmpty()) {
                System.out.println("[vac�o]");
            } else {
                for (Register reg : table[i]) {
                    System.out.print(reg + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}

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
         
        }

        public Register search(int key) {
        	
        }

    }
}

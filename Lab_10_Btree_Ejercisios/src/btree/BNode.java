package btree;

import java.util.ArrayList;

// Clase para representar un nodo de un Árbol B
public class BNode<E extends Comparable<E>> {
    public static int IDGEN = 0; // Contador de nodos
    public int idNode;           // ID único del nodo
    public int count;            // Cantidad de claves
    public ArrayList<E> keys;    // Lista de claves
    public ArrayList<BNode<E>> childs; // Hijos del nodo

    // Constructor
    public BNode(int orden) {
        this.idNode = IDGEN++;
        this.count = 0;
        this.keys = new ArrayList<>();
        this.childs = new ArrayList<>();
        for (int i = 0; i < orden; i++) {
            keys.add(null);
            childs.add(null);
        }
        childs.add(null); // Último hijo
    }

    // Método para buscar una clave en el nodo actual
    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < count && key.compareTo(keys.get(pos[0])) > 0) {
            pos[0]++;
        }
        return (pos[0] < count && key.compareTo(keys.get(pos[0])) == 0);
    }

    // Para imprimir el nodo de forma legible
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nodo ").append(idNode).append(" [");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i));
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}


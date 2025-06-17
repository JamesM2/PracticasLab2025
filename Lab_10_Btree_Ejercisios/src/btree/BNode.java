package btree;

import java.util.ArrayList;

// Nodo genérico de un Árbol B
public class BNode<E extends Comparable<E>> {
    public static int IDGEN = 0; // Generador de IDs para nodos
    public int idNode;
    public int count;
    public ArrayList<E> keys;
    public ArrayList<BNode<E>> childs;

    public BNode(int orden) {
        this.idNode = IDGEN++;
        this.count = 0;
        this.keys = new ArrayList<>();
        this.childs = new ArrayList<>();
        for (int i = 0; i < orden; i++) {
            keys.add(null);
            childs.add(null);
        }
        childs.add(null); // Un hijo extra
    }

    // Busca una clave en este nodo
    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < count && key.compareTo(keys.get(pos[0])) > 0) {
            pos[0]++;
        }
        return (pos[0] < count && key.compareTo(keys.get(pos[0])) == 0);
    }

    // Muestra los valores del nodo
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

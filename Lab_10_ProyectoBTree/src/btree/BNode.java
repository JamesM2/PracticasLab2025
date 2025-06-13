package btree;

import java.util.ArrayList;

// Nodo del árbol B con claves comparables
public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected static int nodeCounter = 0;
    protected int idNode;

    public BNode(int n) {
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1);
        for (int i = 0; i < n; i++) {
            this.keys.add(null);
            this.childs.add(null);
        }
        this.childs.add(null);
        this.count = 0;
        this.idNode = ++nodeCounter;
    }

    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }

    public boolean nodeEmpty() {
        return count == 0;
    }

    public boolean searchNode(E key, int[] pos) {
        int i = 0;
        while (i < count && key.compareTo(keys.get(i)) > 0) {
            i++;
        }
        pos[0] = i;
        return (i < count && key.compareTo(keys.get(i)) == 0);
    }

    public String toString() {
        return "Nodo ID: " + idNode + " | Llaves: " + keys.subList(0, count);
    }
}

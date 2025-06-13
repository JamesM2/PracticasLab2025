package btree;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana = push(root, cl);
        if (up) {
            BNode<E> nuevo = new BNode<>(orden);
            nuevo.count = 1;
            nuevo.keys.set(0, mediana);
            nuevo.childs.set(0, root);
            nuevo.childs.set(1, nDes);
            root = nuevo;
        }
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean found = current.searchNode(cl, pos);
            if (found) {
                System.out.println("Elemento duplicado");
                up = false;
                return null;
            }

            E mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(orden - 1)) {
                    mediana = divideNode(current, cl, pos[0]);
                } else {
                    insertNode(current, cl, nDes, pos[0]);
                    up = false;
                }
            }
            return mediana;
        }
    }

    private void insertNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        for (int i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E divideNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int posMdna = (k <= orden / 2) ? orden / 2 : orden / 2 + 1;
        nDes = new BNode<>(orden);

        for (int i = posMdna; i < orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }

        nDes.count = (orden - 1) - posMdna;
        current.count = posMdna;

        if (k <= orden / 2) {
            insertNode(current, cl, rd, k);
        } else {
            insertNode(nDes, cl, rd, k - posMdna);
        }

        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;
        return median;
    }

    public void print() {
        printNode(root, "");
    }

    private void printNode(BNode<E> node, String prefix) {
        if (node != null) {
            System.out.println(prefix + node);
            for (int i = 0; i <= node.count; i++) {
                printNode(node.childs.get(i), prefix + "  ");
            }
        }
    }
}

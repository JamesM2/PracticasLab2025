package colecciones;

import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista = new ArrayList<>();
    private int tope = 3;

    public void add(T objeto) {
        if (lista.size() < tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("No caben más elementos en la bolsa");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return lista.iterator();
    }

    public T[] toArray(T[] arr) {
        return lista.toArray(arr);
    }
}

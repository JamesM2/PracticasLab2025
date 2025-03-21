package comejemplobolsa;

import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista;
    private int tope;

    public Bolsa(int tope) {
        this.tope = tope;
        this.lista = new ArrayList<>();
    }

    public void add(T objeto) {
        if (lista.size() < tope) { // Evita agregar m�s elementos de los permitidos
            lista.add(objeto);
        } else {
            throw new RuntimeException("No caben m�s objetos en la bolsa.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return lista.iterator();
    }
}

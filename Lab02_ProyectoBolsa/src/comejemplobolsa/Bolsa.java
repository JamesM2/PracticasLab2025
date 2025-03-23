package comejemplobolsa;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase gen�rica Bolsa que permite almacenar un n�mero limitado de elementos.
 * Implementa la interfaz Iterable para poder recorrer los elementos con un iterador.
 * 
 * @param <T> Tipo de objetos que la bolsa puede contener.
 */
public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista; // Lista interna para almacenar los elementos
    private int tope; // L�mite m�ximo de elementos en la bolsa

    /**
     * Constructor que inicializa la bolsa con un tope m�ximo de elementos.
     * 
     * @param tope N�mero m�ximo de elementos que puede contener la bolsa.
     */
    public Bolsa(int tope) {
        this.tope = tope;
        this.lista = new ArrayList<>();
    }

    /**
     * Agrega un objeto a la bolsa si no supera el l�mite permitido.
     * 
     * @param objeto Elemento a agregar en la bolsa.
     * @throws RuntimeException Si se intenta agregar m�s elementos de los permitidos.
     */
    public void add(T objeto) {
        if (lista.size() < tope) { // Verifica que no se exceda el l�mite
            lista.add(objeto);
        } else {
            throw new RuntimeException("No caben m�s objetos en la bolsa.");
        }
    }

    /**
     * Devuelve un iterador para recorrer los elementos de la bolsa.
     * 
     * @return Un iterador sobre los elementos de la bolsa.
     */
    @Override
    public Iterator<T> iterator() {
        return lista.iterator();
    }
}

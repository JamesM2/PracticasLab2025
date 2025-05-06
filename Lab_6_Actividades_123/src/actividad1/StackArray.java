package actividad1;

public class StackArray<E> implements Stack<E> {
    private E[] array; // Arreglo para almacenar los elementos
    private int tope;  // �ndice del �ltimo elemento insertado

    // Constructor: inicializa el arreglo con tama�o n y pone el tope en -1 (vac�o)
    public StackArray(int n) {
        this.array = (E[]) new Object[n]; // Se hace un cast porque no se pueden crear arreglos gen�ricos directamente
        tope = -1;
    }

    // Inserta un nuevo elemento en la pila
    public void push(E x) {
        if (isFull()) return; // No inserta si est� llena
        array[++tope] = x; // Incrementa el tope y luego inserta
    }

    // Elimina y retorna el elemento del tope
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila est� vac�a.");
        return array[tope--]; // Retorna el tope y luego decrementa
    }

    // Retorna el elemento del tope sin eliminarlo
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila est� vac�a.");
        return array[tope]; // Solo retorna sin eliminar
    }

    // Verifica si la pila est� vac�a
    public boolean isEmpty() {
        return tope == -1;
    }

    // Verifica si la pila est� llena (solo en estructuras est�ticas)
    public boolean isFull() {
        return tope == array.length - 1;
    }

    // Devuelve una cadena con los elementos desde el tope hasta el fondo
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila: [");
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

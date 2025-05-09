package ejercicio2;

// Implementaci�n de una cola usando un arreglo y aritm�tica modular
public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int first;
    private int last;
    private int size;
    private int capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    // Inserta un elemento al final de la cola
    public void enqueue(E x) {
        if (size == capacity) {
            System.out.println("Cola llena. No se puede insertar: " + x);
            return;
        }
        array[last] = x;
        last = (last + 1) % capacity;
        size++;
    }

    // Elimina el elemento del frente de la cola
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola est� vac�a.");
        }
        E aux = array[first];
        first = (first + 1) % capacity;
        size--;
        return aux;
    }

    // Retorna el elemento del frente
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola est� vac�a.");
        }
        return array[first];
    }

    // Retorna el �ltimo elemento insertado
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola est� vac�a.");
        }
        int pos = (last - 1 + capacity) % capacity;
        return array[pos];
    }

    // Verifica si la cola est� vac�a
    public boolean isEmpty() {
        return size == 0;
    }

    // Representaci�n de la cola como cadena
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[(first + i) % capacity];
            if (i != size - 1) result += ", ";
        }
        result += "]";
        return result;
    }
}

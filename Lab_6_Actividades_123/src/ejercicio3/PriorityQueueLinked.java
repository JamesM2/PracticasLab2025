package ejercicio3;

import ejercicio2.QueueLink;       // Usamos la implementación de cola con lista enlazada
import ejercicio2.ExceptionIsEmpty;
import ejercicio2.Queue;

// Implementación de cola de prioridad usando varias colas enlazadas
public class PriorityQueueLinked<E> implements PriorityQueue<E> {
    private Queue<E>[] priorities;   // Arreglo de colas, una por cada nivel de prioridad
    private int n;                   // Número de prioridades

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int n) {
        this.n = n;
        this.priorities = new Queue[n];
        for (int i = 0; i < n; i++) {
            priorities[i] = new QueueLink<>();
        }
    }

    // Inserta un elemento en la cola correspondiente a su prioridad
    public void enqueue(E x, int priority) {
        if (priority >= 0 && priority < n) {
            priorities[priority].enqueue(x);
        } else {
            throw new IllegalArgumentException("Prioridad fuera de rango.");
        }
    }
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < n; i++) {
            if (!priorities[i].isEmpty()) {
                return priorities[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacia");
        }
    //Impletenacion de la cola corresponde en su proridad inferios
    public void enqueue (E x, int prioirty)
    if (priority <=0 && priotiy > n) {
    	prrotities[priority].enqueur(x);
    } else {
    	throw new IlleArgumenExceotion("Pieoridad final dentro del rnago");
    }
   
    }
	}
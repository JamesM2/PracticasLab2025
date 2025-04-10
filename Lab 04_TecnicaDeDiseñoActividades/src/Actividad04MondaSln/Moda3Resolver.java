package Actividad04MondaSln;

import java.util.*;

public class Moda3Resolver {
    // Representa los límites de un subarreglo
    public static class Limits {
        int[] array;
        int prim;
        int ult;

        Limits(int[] array, int prim, int ult) {
            this.array = array;
            this.prim = prim;
            this.ult = ult;
        }

        int length() {
            return ult - prim + 1;
        }
    }

    // Conjunto que administra subarreglos
    public static class SetVectors {
        PriorityQueue<Limits> lista = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.length(), a.length()) // el más largo primero
        );

        void insertar(Limits p) {
            lista.add(p);
        }

        Limits mayor() {
            return lista.poll();
        }

        int longMayor() {
            return lista.isEmpty() ? 0 : lista.peek().length();
        }

        boolean esVacio() {
            return lista.isEmpty();
        }

        void destruir() {
            lista.clear();
        }
    }

    // Función que divide un subarreglo en tres partes según la mediana
    public static void pivote2(int[] a, int mediana, int prim, int ult, int[] izqDer) {
        int izq = prim;
        int der = ult + 1;

        for (int i = prim; i < der;) {
            if (a[i] < mediana) {
                swap(a, i++, izq++);
            } else if (a[i] > mediana) {
                swap(a, i, --der);
            } else {
                i++;
            }
        }
        izqDer[0] = izq;
        izqDer[1] = der;
    }

    private static void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    // Solución 3: divide y vencerás
    public static int moda3(int[] a) {
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();

        Limits p = new Limits(a, 0, a.length - 1);
        heterogeneo.insertar(p);

        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            p = heterogeneo.mayor();

            int mediana = a[(p.prim + p.ult) / 2];
            int[] izqDer = new int[2];

            pivote2(p.array, mediana, p.prim, p.ult, izqDer);

            Limits p1 = new Limits(p.array, p.prim, izqDer[0] - 1);
            Limits p2 = new Limits(p.array, izqDer[0], izqDer[1] - 1);
            Limits p3 = new Limits(p.array, izqDer[1], p.ult);

            if (p1.length() > 0) heterogeneo.insertar(p1);
            if (p3.length() > 0) heterogeneo.insertar(p3);
            if (p2.length() > 0) homogeneo.insertar(p2);
        }

        if (homogeneo.esVacio()) return a[0];

        p = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();

        return p.array[p.prim];
    }
}

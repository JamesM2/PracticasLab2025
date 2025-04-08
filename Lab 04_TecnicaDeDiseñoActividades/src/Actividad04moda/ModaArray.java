package Actividad04moda;
class ModaArray {

    // Funci�n que calcula la moda utilizando el algoritmo Divide y Vencer�s
    public static int moda3(int[] a, int prim, int ult) {
        // Crear un objeto Limits para representar los l�mites del subarreglo
        Limits p = new Limits(prim, ult);
        
        // Crear dos conjuntos para subarreglos homog�neos y heterog�neos
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();

        // Insertar el subarreglo completo en el conjunto heterog�neo
        heterogeneo.insertar(p);

        // Variables para la mediana, izquierda y derecha
        int mediana;
        int[] izq = new int[1];
        int[] der = new int[1];

        // Mientras el conjunto heterog�neo sea m�s grande que el homog�neo, continuar dividiendo
        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            // Extraer el subarreglo m�s largo del conjunto heterog�neo
            p = heterogeneo.mayor();

            // Calcular la mediana del subarreglo
            mediana = a[(p.prim + p.ult) / 2];

            // Dividir el subarreglo en tres partes
            pivote2(a, mediana, p.prim, p.ult, izq, der);

            // Crear subarreglos basados en los �ndices calculados
            Limits p1 = new Limits(p.prim, izq[0] - 1);
            Limits p2 = new Limits(izq[0], der[0] - 1);
            Limits p3 = new Limits(der[0], p.ult);

            // Insertar los nuevos subarreglos en los conjuntos correspondientes
            if (p1.prim < p1.ult) heterogeneo.insertar(p1);
            if (p3.prim < p3.ult) heterogeneo.insertar(p3);
            if (p2.prim < p2.ult) homogeneo.insertar(p2);
        }

        // Si el conjunto homog�neo est� vac�o, devolver el primer elemento
        if (homogeneo.esVacio()) {
            return a[prim];
        }

        // Obtener el subarreglo m�s grande del conjunto homog�neo y devolver su valor
        p = homogeneo.mayor();
        heterogeneo.destruir();  // Limpiar conjuntos
        homogeneo.destruir();    // Limpiar conjuntos
        return a[p.prim];        // Devolver la moda
    }

    // Funci�n para dividir el arreglo en tres partes usando un pivote (mediana)
    public static void pivote2(int[] array, int mediana, int prim, int ult, int[] izq, int[] der) {
        int i = prim;
        int j = ult;
        while (i <= j) {
            while (array[i] < mediana) i++;
            while (array[j] > mediana) j--;
            if (i <= j) {
                // Intercambiar elementos
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // Asignar los �ndices de los subarreglos izquierdo y derecho
        izq[0] = i;
        der[0] = j;
    }
}

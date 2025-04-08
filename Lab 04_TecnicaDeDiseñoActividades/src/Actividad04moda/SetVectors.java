package Actividad04moda;
import java.util.ArrayList; // Importa la clase ArrayList

//Clase SetVectors que maneja conjuntos de subarreglos
class SetVectors {
 // Lista para almacenar los objetos Limits (subarreglos)
 private ArrayList<Limits> conjunto;

 // Constructor que inicializa la lista
 public SetVectors() {
     conjunto = new ArrayList<>();
 }

 // M�todo para insertar un subarreglo (Limits) en el conjunto
 public void insertar(Limits limit) {
     conjunto.add(limit);
 }

 // M�todo para verificar si el conjunto est� vac�o
 public boolean esVacio() {
     return conjunto.isEmpty();
 }

 // M�todo para obtener el subarreglo m�s largo
 public Limits mayor() {
     Limits mayor = null;
     for (Limits lim : conjunto) {
         if (mayor == null || (lim.ult - lim.prim) > (mayor.ult - mayor.prim)) {
             mayor = lim;
         }
     }
     return mayor;
 }

 // M�todo para obtener la longitud del subarreglo m�s largo
 public int longMayor() {
     int maxLength = 0;
     for (Limits lim : conjunto) {
         maxLength = Math.max(maxLength, (lim.ult - lim.prim));
     }
     return maxLength;
 }

 // M�todo para limpiar el conjunto de subarreglos
 public void destruir() {
     conjunto.clear();
 }
}

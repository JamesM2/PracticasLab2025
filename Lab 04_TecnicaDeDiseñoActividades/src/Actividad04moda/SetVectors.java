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

 // Método para insertar un subarreglo (Limits) en el conjunto
 public void insertar(Limits limit) {
     conjunto.add(limit);
 }

 // Método para verificar si el conjunto está vacío
 public boolean esVacio() {
     return conjunto.isEmpty();
 }

 // Método para obtener el subarreglo más largo
 public Limits mayor() {
     Limits mayor = null;
     for (Limits lim : conjunto) {
         if (mayor == null || (lim.ult - lim.prim) > (mayor.ult - mayor.prim)) {
             mayor = lim;
         }
     }
     return mayor;
 }

 // Método para obtener la longitud del subarreglo más largo
 public int longMayor() {
     int maxLength = 0;
     for (Limits lim : conjunto) {
         maxLength = Math.max(maxLength, (lim.ult - lim.prim));
     }
     return maxLength;
 }

 // Método para limpiar el conjunto de subarreglos
 public void destruir() {
     conjunto.clear();
 }
}

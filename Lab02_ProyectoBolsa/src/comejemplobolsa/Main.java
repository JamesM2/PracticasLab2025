package comejemplobolsa;

public class Main {
    public static void main(String[] args) {
        // Crear una bolsa de chocolatinas con capacidad para 3 elementos
        Bolsa<Chocolatina> bolsaChocolatinas = new Bolsa<>(3);

        // Agregar chocolatinas a la bolsa
        try {
            bolsaChocolatinas.add(new Chocolatina("Nestlé"));
            bolsaChocolatinas.add(new Chocolatina("Ferrero Rocher"));
            bolsaChocolatinas.add(new Chocolatina("Milka"));

            // Intentar agregar una más (esto generará un error)
            bolsaChocolatinas.add(new Chocolatina("Lindt"));  
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Recorrer la bolsa e imprimir los elementos
        System.out.println("Contenido de la bolsa de chocolatinas:");
        for (Chocolatina choco : bolsaChocolatinas) {
            System.out.println(choco);
        }

        // Crear y probar una bolsa de golosinas
        Bolsa<Golosina> bolsaGolosinas = new Bolsa<>(2);
        bolsaGolosinas.add(new Golosina("Caramelo", 10.5));
        bolsaGolosinas.add(new Golosina("Gomita", 5.3));

        System.out.println("\nContenido de la bolsa de golosinas:");
        for (Golosina golo : bolsaGolosinas) {
            System.out.println(golo);
        }
    }
}

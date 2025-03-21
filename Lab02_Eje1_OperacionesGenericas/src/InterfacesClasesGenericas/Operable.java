package InterfacesClasesGenericas;

/**
 * Interfaz genérica que define operaciones matemáticas básicas y avanzadas.
 * 
 * @param <N> Tipo de dato numérico que extiende de {@link Number}.
 */
public interface Operable<N extends Number> {

    /**
     * Realiza la suma de dos números.
     * 
     * @param operando1 Primer operando.
     * @param operando2 Segundo operando.
     * @return Resultado de la suma.
     */
    N suma(N operando1, N operando2);

    /**
     * Realiza la resta de dos números.
     * 
     * @param operando1 Minuendo.
     * @param operando2 Sustraendo.
     * @return Resultado de la resta.
     */
    N resta(N operando1, N operando2);

    /**
     * Realiza el producto de dos números.
     * 
     * @param operando1 Primer operando.
     * @param operando2 Segundo operando.
     * @return Resultado del producto.
     */
    N producto(N operando1, N operando2);

    /**
     * Realiza la división de dos números.
     * 
     * @param operando1 Dividendo.
     * @param operando2 Divisor.
     * @return Resultado de la división.
     * @throws ArithmeticException Si el divisor es cero.
     */
    N division(N operando1, N operando2);

    /**
     * Calcula la potencia de un número elevado a otro.
     * 
     * @param base Base de la potencia.
     * @param exponente Exponente al que se elevará la base.
     * @return Resultado de la potenciación.
     */
    N potencia(N base, N exponente);

    /**
     * Calcula la raíz cuadrada de un número.
     * 
     * @param operando Número del que se extraerá la raíz cuadrada.
     * @return Resultado de la raíz cuadrada.
     * @throws ArithmeticException Si el operando es negativo en números que no admiten raíces negativas.
     */
    N raizCuadrada(N operando);

    /**
     * Calcula la raíz cúbica de un número.
     * 
     * @param operando Número del que se extraerá la raíz cúbica.
     * @return Resultado de la raíz cúbica.
     */
    N raizCubica(N operando);
}

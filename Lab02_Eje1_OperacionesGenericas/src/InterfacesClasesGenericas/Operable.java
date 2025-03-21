package InterfacesClasesGenericas;

/**
 * Interfaz gen�rica que define operaciones matem�ticas b�sicas y avanzadas.
 * 
 * @param <N> Tipo de dato num�rico que extiende de {@link Number}.
 */
public interface Operable<N extends Number> {

    /**
     * Realiza la suma de dos n�meros.
     * 
     * @param operando1 Primer operando.
     * @param operando2 Segundo operando.
     * @return Resultado de la suma.
     */
    N suma(N operando1, N operando2);

    /**
     * Realiza la resta de dos n�meros.
     * 
     * @param operando1 Minuendo.
     * @param operando2 Sustraendo.
     * @return Resultado de la resta.
     */
    N resta(N operando1, N operando2);

    /**
     * Realiza el producto de dos n�meros.
     * 
     * @param operando1 Primer operando.
     * @param operando2 Segundo operando.
     * @return Resultado del producto.
     */
    N producto(N operando1, N operando2);

    /**
     * Realiza la divisi�n de dos n�meros.
     * 
     * @param operando1 Dividendo.
     * @param operando2 Divisor.
     * @return Resultado de la divisi�n.
     * @throws ArithmeticException Si el divisor es cero.
     */
    N division(N operando1, N operando2);

    /**
     * Calcula la potencia de un n�mero elevado a otro.
     * 
     * @param base Base de la potencia.
     * @param exponente Exponente al que se elevar� la base.
     * @return Resultado de la potenciaci�n.
     */
    N potencia(N base, N exponente);

    /**
     * Calcula la ra�z cuadrada de un n�mero.
     * 
     * @param operando N�mero del que se extraer� la ra�z cuadrada.
     * @return Resultado de la ra�z cuadrada.
     * @throws ArithmeticException Si el operando es negativo en n�meros que no admiten ra�ces negativas.
     */
    N raizCuadrada(N operando);

    /**
     * Calcula la ra�z c�bica de un n�mero.
     * 
     * @param operando N�mero del que se extraer� la ra�z c�bica.
     * @return Resultado de la ra�z c�bica.
     */
    N raizCubica(N operando);
}

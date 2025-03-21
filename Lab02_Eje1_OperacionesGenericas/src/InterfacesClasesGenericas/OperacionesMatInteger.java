package InterfacesClasesGenericas;

/**
 * Implementaci�n de la interfaz {@link Operable} para operar con n�meros enteros ({@link Integer}).
 */
public class OperacionesMatInteger implements Operable<Integer> {

    /**
     * Realiza la suma de dos n�meros enteros.
     * 
     * @param operando1 Primer operando.
     * @param operando2 Segundo operando.
     * @return Resultado de la suma.
     */
    @Override
    public Integer suma(Integer operando1, Integer operando2) {
        return operando1 + operando2;
    }

    /**
     * Realiza la resta de dos n�meros enteros.
     * 
     * @param operando1 Minuendo.
     * @param operando2 Sustraendo.
     * @return Resultado de la resta.
     */
    @Override
    public Integer resta(Integer operando1, Integer operando2) {
        return operando1 - operando2;
    }

    /**
     * Realiza el producto de dos n�meros enteros.
     * 
     * @param operando1 Primer operando.
     * @param operando2 Segundo operando.
     * @return Resultado del producto.
     */
    @Override
    public Integer producto(Integer operando1, Integer operando2) {
        return operando1 * operando2;
    }

    /**
     * Realiza la divisi�n de dos n�meros enteros.
     * 
     * @param operando1 Dividendo.
     * @param operando2 Divisor.
     * @return Resultado de la divisi�n.
     * @throws ArithmeticException Si el divisor es cero.
     */
    @Override
    public Integer division(Integer operando1, Integer operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return operando1 / operando2;
    }

    /**
     * Calcula la potencia de un n�mero entero elevado a otro.
     * 
     * @param base Base de la potencia.
     * @param exponente Exponente al que se elevar� la base.
     * @return Resultado de la potenciaci�n.
     */
    @Override
    public Integer potencia(Integer base, Integer exponente) {
        return (int) Math.pow(base, exponente);
    }

    /**
     * Calcula la ra�z cuadrada de un n�mero entero.
     * 
     * @param operando N�mero del que se extraer� la ra�z cuadrada.
     * @return Resultado de la ra�z cuadrada (convertido a entero).
     */
    @Override
    public Integer raizCuadrada(Integer operando) {
        return (int) Math.sqrt(operando);
    }

    /**
     * Calcula la ra�z c�bica de un n�mero entero.
     * 
     * @param operando N�mero del que se extraer� la ra�z c�bica.
     * @return Resultado de la ra�z c�bica (convertido a entero).
     */
    @Override
    public Integer raizCubica(Integer operando) {
        return (int) Math.cbrt(operando);
    }
}

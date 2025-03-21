package InterfacesClasesGenericas;

/**
 * Implementación de la interfaz {@link Operable} para operar con números enteros ({@link Integer}).
 */
public class OperacionesMatInteger implements Operable<Integer> {

    /**
     * Realiza la suma de dos números enteros.
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
     * Realiza la resta de dos números enteros.
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
     * Realiza el producto de dos números enteros.
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
     * Realiza la división de dos números enteros.
     * 
     * @param operando1 Dividendo.
     * @param operando2 Divisor.
     * @return Resultado de la división.
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
     * Calcula la potencia de un número entero elevado a otro.
     * 
     * @param base Base de la potencia.
     * @param exponente Exponente al que se elevará la base.
     * @return Resultado de la potenciación.
     */
    @Override
    public Integer potencia(Integer base, Integer exponente) {
        return (int) Math.pow(base, exponente);
    }

    /**
     * Calcula la raíz cuadrada de un número entero.
     * 
     * @param operando Número del que se extraerá la raíz cuadrada.
     * @return Resultado de la raíz cuadrada (convertido a entero).
     */
    @Override
    public Integer raizCuadrada(Integer operando) {
        return (int) Math.sqrt(operando);
    }

    /**
     * Calcula la raíz cúbica de un número entero.
     * 
     * @param operando Número del que se extraerá la raíz cúbica.
     * @return Resultado de la raíz cúbica (convertido a entero).
     */
    @Override
    public Integer raizCubica(Integer operando) {
        return (int) Math.cbrt(operando);
    }
}

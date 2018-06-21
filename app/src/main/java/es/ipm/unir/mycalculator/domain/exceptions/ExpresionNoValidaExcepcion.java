package es.ipm.unir.mycalculator.domain.exceptions;

public class ExpresionNoValidaExcepcion extends RuntimeException {

    public ExpresionNoValidaExcepcion(String expresion) {
        super("La cadena no es una operación valida: " + expresion);
    }

}

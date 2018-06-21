package es.ipm.unir.mycalculator.domain.exceptions;

public class OperadorNoReconozidoExcepcion extends RuntimeException {

    public OperadorNoReconozidoExcepcion(String operadorStr) {
        super("Operador no reconozido: " + operadorStr);
    }

}

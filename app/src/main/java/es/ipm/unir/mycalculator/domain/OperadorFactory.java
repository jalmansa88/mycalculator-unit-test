package es.ipm.unir.mycalculator.domain;

import es.ipm.unir.mycalculator.domain.exceptions.OperadorNoReconozidoExcepcion;
import es.ipm.unir.mycalculator.domain.operador.OperadorDividir;
import es.ipm.unir.mycalculator.domain.operador.OperadorMultiplicar;
import es.ipm.unir.mycalculator.domain.operador.OperadorRestar;
import es.ipm.unir.mycalculator.domain.operador.OperadorSumar;
import es.ipm.unir.mycalculator.domain.pojo.Operador;

public class OperadorFactory {

    public static Operador getOperador(String operadorString) {
        switch (operadorString) {
            case "*": return new OperadorMultiplicar();
            case "+": return new OperadorSumar();
            case "-": return new OperadorRestar();
            case "/": return new OperadorDividir();
            default: throw new OperadorNoReconozidoExcepcion(operadorString);
        }
    }

}
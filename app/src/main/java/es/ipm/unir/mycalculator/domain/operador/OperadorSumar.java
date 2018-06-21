package es.ipm.unir.mycalculator.domain.operador;

import es.ipm.unir.mycalculator.domain.pojo.Operador;
import es.ipm.unir.mycalculator.domain.pojo.Operando;

public class OperadorSumar extends Operador {

    @Override
    public double execute(Operando operando1, Operando operando2) {
        return operando1.getValue() + operando2.getValue();
    }

}

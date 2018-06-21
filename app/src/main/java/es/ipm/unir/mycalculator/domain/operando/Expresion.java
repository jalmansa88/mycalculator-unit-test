package es.ipm.unir.mycalculator.domain.operando;

import es.ipm.unir.mycalculator.domain.pojo.Operador;
import es.ipm.unir.mycalculator.domain.pojo.Operando;

public class Expresion extends Operando {

    private Operador operador;
    private Operando operando1;
    private Operando operando2;

    public Expresion(Operando operando1, Operador operador, Operando operando2) {
        this.operador = operador;
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    @Override
    public double getValue() {
        return operador.execute(operando1, operando2);
    }

    @Override
    public String toString() {
        return "Expresion{" +
                "operador=" + operador +
                ", operando1=" + operando1 +
                ", operando2=" + operando2 +
                '}';
    }
}
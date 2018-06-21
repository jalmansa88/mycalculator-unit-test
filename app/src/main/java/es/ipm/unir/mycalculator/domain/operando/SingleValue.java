package es.ipm.unir.mycalculator.domain.operando;

import es.ipm.unir.mycalculator.domain.pojo.Operando;

public class SingleValue extends Operando {

    private double value;

    public SingleValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SingleValue{" +
                "value=" + value +
                '}';
    }
}
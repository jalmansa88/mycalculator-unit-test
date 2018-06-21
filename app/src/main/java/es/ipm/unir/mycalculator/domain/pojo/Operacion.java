package es.ipm.unir.mycalculator.domain.pojo;

public class Operacion {

    private final Operando operando;

    public Operacion(Operando operando) {
        this.operando = operando;
    }

    public double execute() {
        return operando.getValue();
    }

}

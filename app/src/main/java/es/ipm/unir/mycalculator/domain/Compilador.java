package es.ipm.unir.mycalculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ipm.unir.mycalculator.domain.exceptions.ExpresionNoValidaExcepcion;
import es.ipm.unir.mycalculator.domain.operando.Expresion;
import es.ipm.unir.mycalculator.domain.operando.SingleValue;
import es.ipm.unir.mycalculator.domain.pojo.Operacion;
import es.ipm.unir.mycalculator.domain.pojo.Operador;
import es.ipm.unir.mycalculator.domain.pojo.Operando;

public class Compilador {

    private final static String REGEX = "((?:\\(.*\\)|[0-9]+(?:\\.[0-9]+)?))[ ]+(.)[ ]+((?:\\(.*\\)|[0-9]+(?:\\.[0-9]+)?))";

    public Operacion parse(String operacion) {
        return new Operacion(parseExpresion(operacion));
    }

    private Operando parseExpresion(String operacion) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(operacion);

        if (matcher.matches()) {
            Operador operador = OperadorFactory.getOperador(matcher.group(2));
            Operando operando1 = parseOperando(matcher.group(1));
            Operando operando2 = parseOperando(matcher.group(3));
            return new Expresion(operando1, operador, operando2);
        } else {
            throw new ExpresionNoValidaExcepcion(operacion);
        }
    }

    private Operando parseOperando(String operandoStr) {

        Operando result;

        if (operandoStr.startsWith("(")) {
            result = parseExpresion(operandoStr.substring(1, operandoStr.length()-1));
        } else {
            result = new SingleValue(Double.valueOf(operandoStr));
        }

        return result;
    }

}
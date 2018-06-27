package es.ipm.unir.mycalculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.ipm.unir.mycalculator.domain.OperadorFactory;
import es.ipm.unir.mycalculator.domain.operador.OperadorMultiplicar;
import es.ipm.unir.mycalculator.domain.operando.Expresion;
import es.ipm.unir.mycalculator.domain.pojo.Operador;
import es.ipm.unir.mycalculator.domain.pojo.Operando;
import es.ipm.unir.mycalculator.domain.operando.SingleValue;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpresionTest {

    @Mock
    Operador operador;

    @Mock
    Operando operando1;

    @Mock
    Operando operando2;

    private Expresion expresion;

    @Test
    public void mockTest() {

        when(operador.execute(operando1, operando2)).thenReturn(5.0);

        expresion = new Expresion(operando1, operador, operando2);
        assertEquals(5.0, expresion.getValue());
    }

    @Test
    public void expresionIntegrationTest_1() {
        Operador operador = OperadorFactory.getOperador("*");
        Operando operando1 = new SingleValue(5);
        Operando operando2 = new SingleValue(5);
        Expresion expresion = new Expresion(operando1, operador, operando2);

        Expresion expresion2 = new Expresion(expresion, operador, operando2);

        assertEquals(25.0, expresion.getValue());
        assertEquals(125.0, expresion2.getValue());
    }

    @Test
    public void expresionIntegrationTest_2() {
        Operador operador = OperadorFactory.getOperador("/");
        Operando operando1 = new SingleValue(5);
        Operando operando2 = new SingleValue(5);
        Expresion expresion = new Expresion(operando1, operador, operando2);

        Expresion expresion2 = new Expresion(expresion, operador, operando2);

        assertEquals(1.0, expresion.getValue());
        assertEquals(0.2, expresion2.getValue());
    }

}

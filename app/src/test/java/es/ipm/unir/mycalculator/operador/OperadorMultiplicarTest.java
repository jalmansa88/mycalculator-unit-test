package es.ipm.unir.mycalculator.operador;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.ipm.unir.mycalculator.domain.operador.OperadorMultiplicar;
import es.ipm.unir.mycalculator.domain.pojo.Operando;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OperadorMultiplicarTest {

    @Mock
    Operando operando1;

    @Mock
    Operando operando2;

    OperadorMultiplicar operador;

    @Before
    public void setUp(){
        operador = new OperadorMultiplicar();
    }

    @Test
    public void basicOperation(){
        when(operando1.getValue()).thenReturn(4.0);
        when(operando2.getValue()).thenReturn(2.0);

        assertEquals(8.0, operador.execute(operando1, operando2));
    }
    @Test
    public void multiplicarZero(){
        when(operando1.getValue()).thenReturn(0.0);
        when(operando2.getValue()).thenReturn(-2.0);

        assertEquals(0.0, operador.execute(operando1, operando2), 0);
    }
    @Test
    public void multiplicarZeroZero(){
        when(operando1.getValue()).thenReturn(0.0);
        when(operando2.getValue()).thenReturn(0.0);

        assertEquals(0.0, operador.execute(operando1, operando2));
    }
    @Test
    public void multiplicarZeroNegativo(){
        when(operando1.getValue()).thenReturn(-8.0);
        when(operando2.getValue()).thenReturn(4.5);

        assertEquals(-36.0, operador.execute(operando1, operando2));
    }
}

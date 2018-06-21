package es.ipm.unir.mycalculator.operador;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.ipm.unir.mycalculator.domain.operador.OperadorRestar;
import es.ipm.unir.mycalculator.domain.pojo.Operando;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OperadorRestarTest {

    @Mock
    Operando operando1;

    @Mock
    Operando operando2;

    OperadorRestar operador;

    @Before
    public void setUp(){
        operador = new OperadorRestar();
    }

    @Test
    public void basicOperation(){
        when(operando1.getValue()).thenReturn(50D);
        when(operando2.getValue()).thenReturn(2.3);

        assertEquals(47.7, operador.execute(operando1, operando2));
    }

    @Test
    public void resultadoNegativo(){
        when(operando1.getValue()).thenReturn(5D);
        when(operando2.getValue()).thenReturn(6.5);

        assertEquals(-1.5, operador.execute(operando1, operando2));
    }
    @Test
    public void restaNegativa_suma(){
        when(operando1.getValue()).thenReturn(5D);
        when(operando2.getValue()).thenReturn(-5D);

        assertEquals(10D, operador.execute(operando1, operando2));
    }
    @Test
    public void restaNegativa_zero(){
        when(operando1.getValue()).thenReturn(-5D);
        when(operando2.getValue()).thenReturn(-5D);

        assertEquals(0.0, operador.execute(operando1, operando2));
    }
}

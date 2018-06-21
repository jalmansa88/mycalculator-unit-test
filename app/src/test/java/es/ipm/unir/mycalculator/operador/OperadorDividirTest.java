package es.ipm.unir.mycalculator.operador;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.ipm.unir.mycalculator.domain.operador.OperadorDividir;
import es.ipm.unir.mycalculator.domain.pojo.Operando;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OperadorDividirTest {

    @Mock
    Operando operando1;

    @Mock
    Operando operando2;

    private OperadorDividir operacion;

    @Before
    public void setUp(){
        operacion = new OperadorDividir();
    }

    @Test
    public void basico(){
        when(operando1.getValue()).thenReturn(4.0);
        when(operando2.getValue()).thenReturn(-2.0);

        assertEquals(-2.0, operacion.execute(operando1, operando2));
    }

    @Test
    public void divisionPorCero(){
        when(operando1.getValue()).thenReturn(4.0);
        when(operando2.getValue()).thenReturn(0.0);

        assertEquals(Double.valueOf("Infinity"), operacion.execute(operando1, operando2));
    }

    @Test
    public void ceroEntreCero(){
        when(operando1.getValue()).thenReturn(0.0);
        when(operando2.getValue()).thenReturn(0.0);

        assertEquals(Double.valueOf("NaN"), operacion.execute(operando1, operando2));
    }

    @Test
    public void divisionDeCero(){
        when(operando1.getValue()).thenReturn(0.0);
        when(operando2.getValue()).thenReturn(4.0);

        assertEquals(0.0, operacion.execute(operando1, operando2));
    }
}

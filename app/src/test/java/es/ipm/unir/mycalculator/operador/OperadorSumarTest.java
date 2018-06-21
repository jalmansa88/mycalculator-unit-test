package es.ipm.unir.mycalculator.operador;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import es.ipm.unir.mycalculator.domain.operador.OperadorSumar;
import es.ipm.unir.mycalculator.domain.pojo.Operando;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class OperadorSumarTest {

    @Mock
    Operando operando1;
    @Mock
    Operando operando2;

    private OperadorSumar operacion;

    @Parameters(name = " ( {0} ) + ( {1} ) = {2} ")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1d, 1d, 2d},
                {3d, -2d, 1d},
                {-3d, 0d, -3d},
                {0d, 0d, 0d}
        });
    }
    double expected;
    double op1_inputValue;
    double op2_inputValue;

    public OperadorSumarTest(double o1, double o2, double expected){
        this.op1_inputValue = o1;
        this.op2_inputValue = o2;
        this.expected = expected;
    }

    @Before
    public void setUp(){
        operacion = new OperadorSumar();
        initMocks(this);
    }

    @Test
    public void test(){
        when(operando1.getValue()).thenReturn(op1_inputValue);
        when(operando2.getValue()).thenReturn(op2_inputValue);

        assertEquals(expected, operacion.execute(operando1, operando2));
    }
}

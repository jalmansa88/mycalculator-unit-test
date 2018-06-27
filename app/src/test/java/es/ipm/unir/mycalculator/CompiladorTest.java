package es.ipm.unir.mycalculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.ipm.unir.mycalculator.domain.Compilador;
import es.ipm.unir.mycalculator.domain.exceptions.ExpresionNoValidaExcepcion;

import static junit.framework.Assert.assertEquals;

public class CompiladorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    Compilador compilador;

    @Before
    public void setUp(){
        compilador = new Compilador();
    }

    @Test
    public void basic() {
        assertEquals(10.1, compilador.parse("1.1  + (2.0 + (5 + 2))").execute());
    }

    @Test
    public void basic_2() {
        assertEquals(3.0, compilador.parse("1.0 + 2.0").execute());
    }

    @Test
    public void notValidExpression_1() {

        String operacion = "1.1 + (8";

        exception.expect(ExpresionNoValidaExcepcion.class);
        exception.expectMessage("La cadena no es una operación valida: " + operacion);

        compilador.parse(operacion).execute();
    }

    @Test
    public void notValidExpression_2() {

        String operacion = "5 +- 8";

        exception.expect(ExpresionNoValidaExcepcion.class);
        exception.expectMessage("La cadena no es una operación valida: " + operacion);

        compilador.parse(operacion).execute();
    }
    @Test
    public void notValidExpression_3() {

        String operacion = "6 )";

        exception.expect(ExpresionNoValidaExcepcion.class);
        exception.expectMessage("La cadena no es una operación valida: " + operacion);

        compilador.parse(operacion).execute();
    }

    @Test
    public void notValidExpression_4() {

        String operacion = "( 3 + 4";

        exception.expect(ExpresionNoValidaExcepcion.class);
        exception.expectMessage("La cadena no es una operación valida: " + operacion);

        compilador.parse(operacion).execute();
    }

    @Test
    public void notValidExpression_6() {
        String operacion = "(9 + 2)";

        exception.expect(ExpresionNoValidaExcepcion.class);
        exception.expectMessage("La cadena no es una operación valida: " + operacion);

        compilador.parse(operacion).execute();
    }

    @Test
    public void notValidExpression_7() {
        String operacion = "* 2";

        exception.expect(ExpresionNoValidaExcepcion.class);
        exception.expectMessage("La cadena no es una operación valida: " + operacion);

        compilador.parse(operacion).execute();
    }

    @Test
    public void notValidExpression_8() {
        String operacion = "1 * 2 / 3";

        exception.expect(ExpresionNoValidaExcepcion.class);
        exception.expectMessage("La cadena no es una operación valida: " + operacion);

        compilador.parse(operacion).execute();
    }

}
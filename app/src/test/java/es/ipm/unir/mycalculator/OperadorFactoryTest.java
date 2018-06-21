package es.ipm.unir.mycalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.ipm.unir.mycalculator.domain.OperadorFactory;
import es.ipm.unir.mycalculator.domain.exceptions.OperadorNoReconozidoExcepcion;
import es.ipm.unir.mycalculator.domain.operador.OperadorDividir;
import es.ipm.unir.mycalculator.domain.operador.OperadorMultiplicar;
import es.ipm.unir.mycalculator.domain.operador.OperadorRestar;
import es.ipm.unir.mycalculator.domain.operador.OperadorSumar;

import static junit.framework.Assert.assertTrue;

public class OperadorFactoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void devuelveOperadorMultiplicar(){
        assertTrue(OperadorFactory.getOperador("*") instanceof OperadorMultiplicar);
    }
    @Test
    public void devuelveOperadorSumar(){
        assertTrue(OperadorFactory.getOperador("+") instanceof OperadorSumar);
    }
    @Test
    public void devuelveOperadorRestar(){
        assertTrue(OperadorFactory.getOperador("-") instanceof OperadorRestar);
    }
    @Test
    public void devuelveOperadorDividir(){
        assertTrue(OperadorFactory.getOperador("/") instanceof OperadorDividir);
    }
    @Test
    public void exceptionSiOperadorNoValido(){

        exception.expect(OperadorNoReconozidoExcepcion.class);
        exception.expectMessage("*-");

        OperadorFactory.getOperador("*-");
    }
    @Test
    public void exceptionSiOperadorVacio(){

        exception.expect(OperadorNoReconozidoExcepcion.class);
        exception.expectMessage("");

        OperadorFactory.getOperador("");
    }
    @Test
    public void exceptionSiOperadorEspacio(){

        exception.expect(OperadorNoReconozidoExcepcion.class);
        exception.expectMessage(" ");

        OperadorFactory.getOperador(" ");
    }
}

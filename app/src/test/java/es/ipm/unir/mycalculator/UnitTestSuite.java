package es.ipm.unir.mycalculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import es.ipm.unir.mycalculator.operador.OperadoresTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CompiladorTest.class, ExpresionTest.class, OperadoresTestSuite.class})
public class UnitTestSuite {


}

package sandbox.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void shouldCalculateSimpleOps() {
		assertEquals(10.00, Calculator.eval("5+5"));
		assertEquals(25.00, Calculator.eval("5*5"));
		assertEquals(6.00, Calculator.eval("2+2*2"));
	}
	
	@Test
	public void shouldCalculateNestedExpresions() {
		assertEquals(8.00, Calculator.eval("5+(5-2)"));
		assertEquals(40.00, Calculator.eval("5*(5+3)"));
		assertEquals(0.00, Calculator.eval("20 - 2 * (2*5)*(5-4)"));
	}
	
}

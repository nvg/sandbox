package ctci.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ctci.calc.IntegerCalculator;

public class IntegerCalculatorTest {

	@Test
	public void shouldCalculateSimpleOps() {
		assertEquals(10, IntegerCalculator.eval("10"));
		assertEquals(10, IntegerCalculator.eval("5+5"));
		assertEquals(25, IntegerCalculator.eval("5*5"));
		assertEquals(6, IntegerCalculator.eval("2+2*2"));
		assertEquals(24, IntegerCalculator.eval("2*3*4"));
		assertEquals(2, IntegerCalculator.eval("2*3*4/12"));
		assertEquals(40, IntegerCalculator.eval("2^2*3*4-8"));
		assertEquals(8, IntegerCalculator.eval("10-3+1"));
		assertEquals(4, IntegerCalculator.eval("2*8/4"));
		assertEquals(2, IntegerCalculator.eval("2*8/4*2"));
	}
	
	@Test
	public void shouldFailOnMalformedExpressions() {
		assertThrows(Exception.class, () -> {			
			IntegerCalculator.eval("5+5-");
		});
		
		assertThrows(Exception.class, () -> {			
			IntegerCalculator.eval("a+5-");
		});
		
		assertThrows(Exception.class, () -> {			
			IntegerCalculator.eval("z+d");
		});
	}

	@Test
	public void shouldCalculateNestedExpresions() {
		assertEquals(8, IntegerCalculator.eval("5+(5-2)"));
		assertEquals(40, IntegerCalculator.eval("5*(5+3)"));
		assertEquals(-18, IntegerCalculator.eval("2-2*(2*5)*(5-4)"));
		assertEquals(64, IntegerCalculator.eval("2*2*2*(2*(2*2))"));
		assertEquals(64, IntegerCalculator.eval("2*2*2*(2*(2*2"));
	}

}

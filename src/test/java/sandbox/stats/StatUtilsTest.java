package sandbox.stats;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatUtilsTest {

	@Test
	void shouldComputeCorrectMean() {
		double[] vals = new double[] {600, 470, 170, 430, 300};
		assertEquals(394, StatUtils.getArithmeticMean(vals), 0.0001);
	}
	
	

}

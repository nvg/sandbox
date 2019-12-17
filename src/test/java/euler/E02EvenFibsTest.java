package euler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class E02EvenFibsTest {

	@Test
	void test() {
		E02EvenFibs f = new E02EvenFibs();
		assertEquals(2 + 8 + 34, f.burteForceNotExceeding(45));
		assertEquals(2 + 8 + 34, f.burteForceNotExceedingOptimized(45));
	}

}

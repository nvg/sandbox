package euler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class E01MultiplesOf3And5Test {

	@Test
	void test() {
		E01MultiplesOf3And5 m = new E01MultiplesOf3And5();
		assertEquals(23, m.bruteForceCount(10));
		assertEquals(23, m.countMultiples(10));
		assertEquals(233168, m.countMultiples(1000));
	}
	
	

}

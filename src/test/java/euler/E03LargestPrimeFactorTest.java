package euler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class E03LargestPrimeFactorTest {

	@Test
	void test() {
		E03LargestPrimeFactor f = new E03LargestPrimeFactor();

		assertEquals(29, f.getLargestPrimeFactor(13195));
		// too long :) assertEquals(6857, f.getLargestPrimeFactor(600851475143L));
		assertEquals(29, f.maxPrimeFactorEfficient(13195));
		assertEquals(6857, f.maxPrimeFactorEfficient(600851475143L));
	}

}

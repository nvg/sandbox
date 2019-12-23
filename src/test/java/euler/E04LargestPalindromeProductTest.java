package euler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class E04LargestPalindromeProductTest {

	@Test
	void test() {
		E04LargestPalindromeProduct p = new E04LargestPalindromeProduct();
		assertEquals(906609, p.getLargestPalindromeBruteForce());
	}

}

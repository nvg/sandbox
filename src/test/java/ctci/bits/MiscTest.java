package ctci.bits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MiscTest {

	@Test
	void test() {
		assertTrue(Misc.isPalindrome(1010101));
		assertTrue(Misc.isPalindrome(2));
		assertTrue(Misc.isPalindrome(9990999));
		assertTrue(Misc.isPalindrome(123454321));
		assertFalse(Misc.isPalindrome(99283));
		assertFalse(Misc.isPalindrome(73844));
	}

}

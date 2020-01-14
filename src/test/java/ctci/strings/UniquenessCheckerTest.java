package ctci.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.strings.UniquenessChecker;

class UniquenessCheckerTest {

	@Test
	void test() {
		// is it ASCII or Unicode string?
		//  - can return false if string length exceeds the # of unique characters in the charset
		UniquenessChecker uc = new UniquenessChecker();
		assertTrue(uc.testAllUniqueInplace("abcd"));
		assertFalse(uc.testAllUniqueInplace("abcda"));
	}

}

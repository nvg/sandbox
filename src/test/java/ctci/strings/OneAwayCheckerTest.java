package ctci.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.strings.OneAwayChecker;

class OneAwayCheckerTest {

	@Test
	void test() {
		OneAwayChecker c = new OneAwayChecker();
		assertTrue(c.isOneAway("pale", "ple"));
		assertTrue(c.isOneAway("pales", "pale"));
		assertTrue(c.isOneAway("pale", "bale"));
		assertFalse(c.isOneAway("pale", "bae"));
		assertFalse(c.isOneAway("baba", "abab"));
	}

}

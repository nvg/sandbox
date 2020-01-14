package ctci.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.strings.PermutationChecker;

class PermutationCheckerTest {

	@Test
	void shouldCheckPalindromePermutations() {
		PermutationChecker pc = new PermutationChecker();
		assertTrue(pc.isPalindromePermutation("carerac"));
		assertFalse(pc.isPalindromePermutation("code"));
	}

	@Test
	void shouldComputePermutations() {
		PermutationChecker pc = new PermutationChecker();
		assertTrue(pc.isPermutationNaive("abcd", "dcba"));
		assertFalse(pc.isPermutationNaive("aaa", "bbb"));
		assertFalse(pc.isPermutationNaive("aabc", "abcd"));
	}

}

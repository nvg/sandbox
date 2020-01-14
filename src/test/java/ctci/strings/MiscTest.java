package ctci.strings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ctci.strings.Misc;

class MiscTest {

	@Test
	void testDups() {
		Set<Character> check = new HashSet<>();
		check.add('a');
		check.add('b');
		assertEquals(check, Misc.getDuplicates("aaabbc"));
	}

	@Test
	void testReverse() {
		assertTrue(Misc.isReverse("abc", "cba"));
		assertFalse(Misc.isReverse("a b c", "cba"));
		assertTrue(Misc.isReverse("test", "tset"));
		assertFalse(Misc.isReverse("solo ", " solo"));
		assertTrue(Misc.isReverse("solo ", " olos"));
	}

	@Test
	void testAnagram() {
		assertTrue(Misc.isAnagram("word", "wrdo"));
		assertTrue(Misc.isAnagram("mary", "army"));
		assertTrue(Misc.isAnagram("stop", "tops"));
		assertTrue(Misc.isAnagram("boat", "btoa"));
		assertFalse(Misc.isAnagram("pure", "in"));
		assertFalse(Misc.isAnagram("fill", "fil"));
		assertFalse(Misc.isAnagram("b", "bbb"));
		assertFalse(Misc.isAnagram("ccc", "ccccccc"));
		assertTrue(Misc.isAnagram("a", "a"));
		assertFalse(Misc.isAnagram("sleep", "slep"));

		assertFalse(Misc.isAnagram("rail safety frist", "fairy tales"));
		assertTrue(Misc.isAnagram("rail safety", "fairy tales"));
		assertTrue(Misc.isAnagram("debit card", "bad credit"));
		assertTrue(Misc.isAnagram("George Bush", "he bugs Gore"));
		assertTrue(Misc.isAnagram("Justin Timberlake", "I'm a jerk but listen"));
		assertTrue(Misc.isAnagram("New York Times", "monkeys write"));
		assertTrue(Misc.isAnagram("Church of Scientology", "rich-chosen goofy cult"));
		assertTrue(Misc.isAnagram("McDonald's restaurants", "Uncle Sam's standard rot"));
	}

	@Test
	void testRecursiveReverse() {
		assertEquals("bcda", Misc.reverse("adcb"));
	}

	@Test
	void testPermutations() {
		Set<String> check = new HashSet<String>();
		check.add("abc");
		check.add("acb");
		check.add("cab");
		check.add("cba");
		check.add("bca");
		check.add("bac");

		assertEquals(check, new HashSet<String>(Misc.getPermutations("abc")));
	}

	@Test
	void testReverseWords() {
		assertEquals("word order one", Misc.reverseWords("one order word"));
	}

}

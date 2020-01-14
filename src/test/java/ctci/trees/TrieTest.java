package ctci.trees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ctci.trees.Trie;

class TrieTest {

	@Test
	void shouldAddWords() {
		Trie t = new Trie();
		t.add("test");
		t.add("tests");

		assertTrue(t.contains("test"));
		assertFalse(t.contains("tes"));

		assertTrue(t.contains("test"));
		assertFalse(t.contains("tes"));
		assertFalse(t.contains("tester"));
	}

	@Test
	void shouldListMatching() {
		Set<String> te = new HashSet<String>(Arrays.asList(new String[] { "terra", "test", "tests", "testing" }));
		Set<String> ca = new HashSet<String>(Arrays.asList(new String[] { "cat", "cart", "cargo", "car" }));
		Set<String> ra = new HashSet<String>(Arrays.asList(new String[] { "random" }));
		Trie t = new Trie();
		t.addAll(te);
		t.addAll(ca);
		t.addAll(ra);

		assertEquals(3, t.listMatching("te", 3).size());
		assertTrue(new HashSet<String>(Arrays.asList(new String[] { "terra", "test", "testing" }))
				.containsAll(t.listMatching("te", 3)));
		assertTrue(ca.containsAll(t.listMatching("ca")));
	}

	@Test
	void shouldListWords() {
		Trie t = new Trie();

		Set<String> words = new HashSet<String>(Arrays.asList(new String[] { "cart", "cat", "cord" }));
		words.forEach(w -> t.add(w));

		assertTrue(words.containsAll(t.list()));
	}

}
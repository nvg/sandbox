package sandbox.lists;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UtilsTest {

	@Test
	void shouldCheckPalindromes() {
		LinkedListNode l = LinkedListNodeTest.toList(1, 2, 3, 4, 5);
		assertFalse(Utils.isPalindromeCloned(l));
		assertFalse(Utils.isPalindromeRecursive(l));
		assertFalse(Utils.isPalindromeStack(l));
		
		l = LinkedListNodeTest.toList(1, 2, 3, 4, 5, 4, 3, 2, 1);
		assertTrue(Utils.isPalindromeCloned(l));
		assertTrue(Utils.isPalindromeRecursive(l));
		assertTrue(Utils.isPalindromeStack(l));
		
		l = LinkedListNodeTest.toList(1, 2, 2, 1);
		assertTrue(Utils.isPalindromeCloned(l));
		assertTrue(Utils.isPalindromeRecursive(l));
		assertTrue(Utils.isPalindromeStack(l));
	}
	
}

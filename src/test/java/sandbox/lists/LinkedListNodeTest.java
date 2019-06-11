package sandbox.lists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListNodeTest {

	@Test
	void test() {
		LinkedListNode list = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(1, new LinkedListNode(2, null))));
		LinkedListNode check = new LinkedListNode(1, new LinkedListNode(2, null));
		assertEquals(check, list.removeDuplicates());
	}

}

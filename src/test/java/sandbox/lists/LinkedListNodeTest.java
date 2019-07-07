package sandbox.lists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListNodeTest {

	@Test
	void shouldRemoveDuplicates() {
		LinkedListNode list = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(1, new LinkedListNode(2, null))));
		LinkedListNode check = new LinkedListNode(1, new LinkedListNode(2, null));
		assertEquals(check, list.removeDuplicates());
		
		list = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(1, new LinkedListNode(2, null))));
		check = new LinkedListNode(1, new LinkedListNode(2, null));
		assertEquals(check, list.removeDuplicatesInON());
	}
	
	@Test
	void shouldGetKthToLast() {
		LinkedListNode list = new LinkedListNode(9, new LinkedListNode(2, new LinkedListNode(1, new LinkedListNode(10, null))));
		LinkedListNode kthToLast = list.getKthToLast(1);
		assertEquals(kthToLast.getValue(), 1);
	}

}

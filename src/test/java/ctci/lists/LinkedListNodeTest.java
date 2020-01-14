package ctci.lists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.lists.LinkedListNode;
import ctci.lists.Utils;

class LinkedListNodeTest {

	static LinkedListNode toList(int... nums) {
		LinkedListNode head = null, node = null;
		for (int i = 0; i < nums.length; i++) {
			LinkedListNode n = new LinkedListNode();
			n.setValue(nums[i]);
			if (i == 0) {
				head = n;
			} else {
				node.setNext(n);
			}
			node = n;

		}
		return head;
	}

	@Test
	void shouldReverse() {
		LinkedListNode list = toList(1, 2, 3, 4, 5);
		LinkedListNode check = toList(5, 4, 3, 2, 1);

		assertEquals(check, list.reverse());
	}

	@Test
	void shouldRemoveDuplicates() {
		LinkedListNode list = toList(1, 2, 1, 2);
		LinkedListNode check = toList(1, 2);
		assertEquals(check, list.removeDuplicates());

		list = toList(1, 2, 1, 2);
		check = toList(1, 2);
		assertEquals(check, list.removeDuplicatesInON());
	}

	@Test
	void shouldGetKthToLast() {
		LinkedListNode list = toList(9, 2, 1, 10);
		LinkedListNode kthToLast = list.getKthToLast(1);
		assertEquals(kthToLast.getValue(), 1);

		kthToLast = list.getKthToLastRecursive(0);
		assertEquals(kthToLast.getValue(), 10);

		kthToLast = list.getKthToLastIterative(0);
		assertEquals(kthToLast.getValue(), 10);
	}

	@Test
	void shouldPartition() {
		LinkedListNode input = toList(3, 5, 8, 5, 10, 2, 1);
		LinkedListNode partitionedOutput = input.partition(5);
		for (int i = 0; i < 3; i++) {
			assertTrue(partitionedOutput.getValue() < 5);
			partitionedOutput = partitionedOutput.getNext();
		}

		for (int i = 3; i < 6; i++) {
			assertTrue(partitionedOutput.getValue() >= 5);
			partitionedOutput = partitionedOutput.getNext();
		}
	}

	@Test
	void shouldSum() {
		LinkedListNode l1 = toList(7, 1, 6);
		LinkedListNode l2 = toList(5, 9, 2);
		assertEquals(toList(2, 1, 9), Utils.addReversedLists(l1, l2));
	}

	@Test
	void shouldDetermineLength() {
		LinkedListNode l1 = toList(1);
		assertEquals(1, l1.getLength());
		l1 = toList(1, 2, 3, 4, 5);
		assertEquals(5, l1.getLength());
	}

	@Test
	void shouldInverse() {
		LinkedListNode l = toList(1, 2, 3, 4, 5);
		assertEquals(toList(5, 4, 3, 2, 1), l.reverseAndClone());
	}

	@Test
	void shouldFindKthNode() {
		LinkedListNode l = toList(1, 2, 3, 4, 5);
		assertEquals(1, l.getKth(0).getValue());
		assertEquals(5, l.getKth(4).getValue());
	}

	@Test
	void shouldFindNoIntersection() {
		LinkedListNode l1 = toList(1, 2, 3, 4, 5);
		LinkedListNode l2 = toList(1, 2, 3, 4, 5);
		assertTrue(l1.isIntersecting(l2) == null);
	}

	@Test
	void shouldFindIntersection() {
		LinkedListNode tail = toList(98, 99, 100);
		LinkedListNode l1 = toList(1, 2);
		l1.getLast().setNext(tail);
		LinkedListNode l2 = toList(1, 2, 3, 4, 5);
		l2.setNext(tail);

		assertTrue(l1.isIntersecting(l2) == tail);
	}

	@Test
	void shouldNotFindLoops() {
		LinkedListNode l1 = toList(1, 2, 3);
		assertFalse(l1.getLoopStart() != null);
	}

	@Test
	void shouldFindLoops() {
		LinkedListNode l1 = toList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		LinkedListNode kth = l1.getKth(4); // 5
		LinkedListNode last = kth.getLast();
		last.setNext(kth);

		assertTrue(l1.getLoopStart() == kth);
	}
}

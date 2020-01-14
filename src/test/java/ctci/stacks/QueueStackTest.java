package ctci.stacks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.stacks.QueueStack;

class QueueStackTest {

	@Test
	void test() {
		QueueStack<Integer> q = new QueueStack<Integer>();

		q.enqueue(1);
		assertEquals(1, q.getSize());
		q.enqueue(2);
		assertEquals(2, q.getSize());
		q.enqueue(3);
		assertEquals(3, q.getSize());

		assertFalse(q.isEmpty());

		assertEquals(3, q.getSize());
		assertEquals(1, q.dequeue());

		assertEquals(2, q.getSize());
		assertEquals(2, q.dequeue());

		assertEquals(1, q.getSize());
		assertEquals(3, q.dequeue());

		assertTrue(q.isEmpty());

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		assertEquals(3, q.getSize());
		assertEquals(1, q.dequeue());

		assertEquals(2, q.getSize());
		assertEquals(2, q.dequeue());

		assertEquals(1, q.getSize());
		assertEquals(3, q.dequeue());

		assertTrue(q.isEmpty());
	}

}

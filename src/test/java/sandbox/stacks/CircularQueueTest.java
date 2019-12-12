package sandbox.stacks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularQueueTest {

	@Test
	void shouldEnqueAndDequeue() {
		CircularQueue<Integer> q = new CircularQueue<Integer>(3);

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);

		assertFalse(q.isEmpty());
		assertTrue(q.isFull());

		assertEquals(3, q.getSize());
		assertEquals(1, q.dequeue());

		assertEquals(2, q.getSize());
		assertEquals(2, q.dequeue());

		assertEquals(1, q.getSize());
		assertEquals(3, q.dequeue());

		assertTrue(q.isEmpty());
		assertFalse(q.isFull());

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
		assertFalse(q.isFull());
	}

}

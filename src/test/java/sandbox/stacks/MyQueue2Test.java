package sandbox.stacks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyQueue2Test {

	@Test
	public void shouldWorksAsAQueue() {
		// queue - fifo
		// push 1-2-3, pop 1-2-3

		MyQueue2<Integer> q = new MyQueue2<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);

		assertEquals(1, q.remove());
		assertEquals(2, q.peek());
		assertEquals(2, q.remove());
		assertEquals(3, q.peek());
		assertEquals(3, q.remove());
		q.add(4);
		assertEquals(4, q.remove());
	}

}

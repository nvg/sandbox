package ctci.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ctci.stacks.AnimalQueue;

public class AnimalQueueTest {

	@Test
	public void shouldEnqueAndDeque() {
		AnimalQueue q = new AnimalQueue();
		q.enqueue(new AnimalQueue.Cat("Fluffy"));
		q.enqueue(new AnimalQueue.Dog("Max"));
		assertEquals("Fluffy", q.dequeAny().getName());
		
		q.enqueue(new AnimalQueue.Cat("Fluffy"));
		assertEquals("Max", q.dequeDogs().getName());
		assertEquals("Fluffy", q.dequeCats().getName());
	}
	
}

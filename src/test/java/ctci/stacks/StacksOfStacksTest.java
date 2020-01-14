package ctci.stacks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.stacks.StackOfStacks;

public class StacksOfStacksTest {

	@Test
	public void shouldSearch() {
		StackOfStacks s = new StackOfStacks(2);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		assertEquals(1, s.search(5));
		assertEquals(2, s.search(4));
		assertEquals(3, s.search(3));
		assertEquals(4, s.search(2));
		assertEquals(5, s.search(1));
		
		s = new StackOfStacks(100);
		assertEquals(-1, s.search(10));
		
		s = new StackOfStacks(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		assertEquals(1, s.search(6));
		assertEquals(2, s.search(5));
		assertEquals(3, s.search(4));
		assertEquals(4, s.search(3));
		assertEquals(5, s.search(2));
		assertEquals(6, s.search(1));
	}
	
	@Test
	public void shouldPushAndPop() {
		StackOfStacks s = new StackOfStacks(2);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		assertTrue(s.pop() == 5);
		assertTrue(s.pop() == 4);
		assertTrue(s.pop() == 3);
		assertTrue(s.pop() == 2);
		assertTrue(s.pop() == 1);
	}
	
}

package ctci.stacks;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ctci.stacks.StackMin;
import ctci.stacks.StackMin2;

public class StackTest {
	@Test
	void testStackMin() {
		StackMin stack = new StackMin();
		stack.push(1);
		stack.push(2);
		stack.push(0);
		assertTrue(stack.min() == 0);
		stack.pop();
		assertTrue(stack.min() == 1);
	}

	@Test
	void testStackMin2() {
		StackMin2 stack2 = new StackMin2();
		stack2.push(1);
		stack2.push(2);
		stack2.push(0);
		assertTrue(stack2.min() == 0);
		stack2.pop();
		assertTrue(stack2.min() == 1);
	}
}

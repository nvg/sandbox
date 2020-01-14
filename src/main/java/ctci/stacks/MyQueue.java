package ctci.stacks;

import java.util.Stack;

public class MyQueue<T> {

	// q vs s - fifo vs lifo - modify peek / pop to go in reverse
	// use 2nd stack to reverse the order of elements (pop s1 and push on s2)
	// each peek / pop, pop everything from s1 onto s2, perform peek / pop, and push
	// it all back
	// performance optimization - use lazy approach - let elements sit in s2 until
	// absolutely must reverse

	private Stack<T> stackNewest = new Stack<>(); // has the newest elements on top
	private Stack<T> stackOldest = new Stack<>(); // has the oldest elements on top

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value) {
		// stackNewest always has the newest element on top
		stackNewest.push(value);
	}

	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}

	public T peek() {
		shiftStacks(); // ensure stackOldest has the current element
		return stackOldest.peek(); // get the oldest item
	}

	public T remove() {
		shiftStacks(); // ensure stackOldest has the current element
		return stackOldest.pop(); // pop the oldest item
	}

}
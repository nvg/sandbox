package sandbox.stacks;

import java.util.Stack;

public class QueueStack<T> {

	// push elements for enquing
	private Stack<T> forwardStack = new Stack<T>();
	// elements in reverse order for dequing - qeque
	private Stack<T> reverseStack = new Stack<T>();

	public void enqueue(T element) {
		if (forwardStack.isEmpty()) {
			while (!reverseStack.isEmpty()) {
				forwardStack.push(reverseStack.pop());
			}
		}
		forwardStack.push(element);
	}

	public T dequeue() {
		if (reverseStack.isEmpty()) {
			while (!forwardStack.isEmpty()) {
				reverseStack.push(forwardStack.pop());
			}
		}

		return reverseStack.pop();
	}

	public boolean isEmpty() {
		return forwardStack.isEmpty() && reverseStack.isEmpty();
	}

	public int getSize() {
		return forwardStack.size() + reverseStack.size();
	}

}

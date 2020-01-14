package ctci.stacks;

public class CircularQueue<T> {

	private static final int EMPTY = -1;
	private static final int DEFAULT_SIZE = 10;

	private Object[] values;

	private int headIndex = EMPTY;
	private int tailIndex = EMPTY;

	public CircularQueue() {
		this(DEFAULT_SIZE);
	}

	public CircularQueue(int capacity) {
		values = new Object[capacity];
	}

	public void enqueue(T value) {
		if (isFull()) {
			throw new RuntimeException("Queue overflow");
		}

		tailIndex = (tailIndex + 1) % values.length;
		values[tailIndex] = value;

		if (headIndex == EMPTY) {
			headIndex = tailIndex;
		}
	}

	public boolean isFull() {
		int nextIndex = (tailIndex + 1) % values.length;
		return nextIndex == headIndex;
	}

	public boolean isEmpty() {
		return headIndex == EMPTY;
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		T result = (T) values[headIndex];
		values[headIndex] = null;

		if (headIndex == tailIndex) {
			headIndex = EMPTY;
		} else {
			headIndex = (headIndex + 1) % values.length;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) values[headIndex];
	}

	public int getSize() {
		return Math.abs(tailIndex - headIndex) % values.length + 1;
	}

}

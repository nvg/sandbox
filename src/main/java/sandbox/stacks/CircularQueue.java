package sandbox.stacks;

public class CircularQueue<T> {

	private Object[] values;

	private int start;
	private int end;
	private int capacity;
	private int size;

	public CircularQueue(int capacity) {
		values = new Object[capacity];
		this.capacity = capacity;
	}

	public void enqueue(T value) {
		if (isFull()) {
			throw new RuntimeException("Queue overflow");
		}
		size++;

		values[end] = value;
		end = (end + 1) % capacity;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		size--;

		T result = (T) values[start];
		values[start] = null;
		start = (start + 1) % capacity;
		return result;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) values[start];
	}

	public int getSize() {
		return size;
	}

}

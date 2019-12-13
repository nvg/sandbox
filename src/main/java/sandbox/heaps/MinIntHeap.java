package sandbox.heaps;

import java.util.Arrays;

/*
 * Implementation options
 * 1. Use recursive tree-like structure
 * 2. Use array
 */
public class MinIntHeap {

	private int capacity = 10;
	private int size;
	private int[] items;

	public MinIntHeap() {
		items = new int[capacity];
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException("Heap is empty");
		}

		return items[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalStateException("Heap is empty");
		}

		int item = items[0];
		items[0] = items[size - 1];
		size--;

		heapifyDown();

		return item;
	}

	public void add(int item) {
		ensureExtraCapacity();

		items[size] = item;
		size++;

		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			// swap child & parent
			swap(getParentIndex(index), index);
			// walk upwards
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if (items[index] < items[smallerChildIndex]) {
				break;
			}
			
			swap(index, smallerChildIndex);
			index = smallerChildIndex;
		}
	}

	private void ensureExtraCapacity() {
		if (size < capacity) {
			return;
		}

		items = Arrays.copyOf(items, capacity * 2);
		capacity *= 2;
	}

	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}

	private boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}
}

package ctci.lists;

public class Zip {

	public LinkedListNode zip(final LinkedListNode node) {
		if (node == null || node.getLength() <= 1) {
			return node;
		}

		// split into two lists
		LinkedListNode firstHalf = node;
		LinkedListNode secondHalf = node;
		int listSize = node.getLength();
		for (int i = 0; i < node.getLength() / 2; i++) {
			LinkedListNode current = secondHalf;
			secondHalf = secondHalf.getNext();

			if (i == listSize - 1) {
				current.setNext(null);
			}
		}

		secondHalf = secondHalf.reverse();

		LinkedListNode result = firstHalf;
		while (true) {

			if (secondHalf == null || firstHalf == null) {
				break;
			}

			LinkedListNode nextEven = firstHalf.getNext();
			LinkedListNode nextOdd = secondHalf.getNext();

			firstHalf.setNext(secondHalf);
			secondHalf.setNext(nextEven);

			firstHalf = nextEven;
			secondHalf = nextOdd;
		}

		return result;
	}

}

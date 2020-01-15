package ctci.lists;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedListNode {

	public static LinkedListNode build(int... ints) {
		LinkedListNode result = new LinkedListNode(ints[0]);
		LinkedListNode node = result;
		for (int i = 1; i < ints.length; i++) {
			LinkedListNode n = new LinkedListNode(ints[i]);
			node.next = n;
			node = n;
		}
		return result;
	}

	private int value;
	private LinkedListNode next;

	public LinkedListNode(int n) {
		setValue(n);
	}

	public LinkedListNode removeDuplicatesInON() {
		Set<Integer> visitedNodes = new HashSet<Integer>();
		visitedNodes.add(this.getValue());

		LinkedListNode prev = this, next = this.next;
		while (next != null) {
			if (visitedNodes.contains(next.getValue())) {
				prev.setNext(next.getNext());
			} else {
				visitedNodes.add(next.value);
				prev = next;
			}
			next = next.getNext();
		}
		return this;
	}

	public LinkedListNode removeDuplicates() {
		LinkedListNode node = this;
		while (node != null) {
			removeDups(node, node.value);
			node = node.next;
		}
		return this;
	}

	public LinkedListNode getKthToLast(int kth) {
		int len = 0;
		LinkedListNode n = this;
		while (n != null) {
			len++;
			n = n.next;
		}

		n = this;
		for (int i = 1; i < (len - kth); i++) {
			n = n.next;
		}
		return n;
	}

	public LinkedListNode getKthToLastIterative(int kth) {
		LinkedListNode ptr1 = this;
		LinkedListNode ptr2 = this;

		int oneBased = kth + 1;
		for (int i = 0; i < oneBased; i++) {
			if (ptr1 == null) {
				return null;
			}
			ptr1 = ptr1.next;
		}

		while (ptr1 != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr2;
	}

	/**
	 * CTCI6 - 2.5
	 */
	public LinkedListNode partition(int n) {
		LinkedListNode lowerStart = null, lowerEnd = null;
		LinkedListNode upperStart = null, upperEnd = null;

		LinkedListNode next = this;
		while (next != null) {
			int val = next.getValue();
			if (val >= n) {
				if (upperStart == null) {
					upperStart = new LinkedListNode(val);
					upperEnd = upperStart;
				} else {
					LinkedListNode nn = new LinkedListNode(val);
					upperEnd.next = nn;
					upperEnd = nn;
				}
			} else {
				if (lowerStart == null) {
					lowerStart = new LinkedListNode(val);
					lowerEnd = lowerStart;
				} else {
					LinkedListNode nn = new LinkedListNode(val);
					lowerEnd.next = nn;
					lowerEnd = nn;
				}
			}
			next = next.getNext();
		}
		lowerEnd.next = upperStart;

		return lowerStart;
	}

	/**
	 * Deletes node from the list in O(1). Note that node must not be the last node
	 * in the list, consider other options, like making it dummy for example.
	 * 
	 * @param n Node to remove.
	 */
	public void deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return;
		}

		LinkedListNode next = n.next;
		n.value = next.value;
		n.next = next.next;
	}

	public LinkedListNode getKthToLastRecursive(int kth) {
		return getKthToLastRecursive(kth + 1, this, new Index());
	}

	private LinkedListNode getKthToLastRecursive(int oneBasedIndex, LinkedListNode node, Index index) {
		if (node == null) {
			return null;
		}

		LinkedListNode n = getKthToLastRecursive(oneBasedIndex, node.next, index);
		index.i++;
		if (index.i == oneBasedIndex) {
			return node;
		}
		return n;
	}

	private static final class Index {
		int i = 0;
	}

	private void removeDups(LinkedListNode node, int value) {
		if (node == null || node.next == null) {
			return;
		}

		if (node.next.value == value) {
			node.next = node.next.next;
		}

		removeDups(node.next, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		LinkedListNode n = (LinkedListNode) obj;

		if (value != n.value) {
			return false;
		}

		if (this.next != null && n.next != null) {
			return this.next.equals(n.next);
		}

		return this.next == null && n.next == null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public String toString() {
		return "[" + value + "] -> " + next;
	}

	public int getLength() {
		if (getNext() == null) {
			return 1;
		}
		return 1 + getNext().getLength();
	}

	public LinkedListNode reverse() {
		return reverse(this);
	}

	private LinkedListNode reverse(LinkedListNode node) {
		LinkedListNode previous = null;
		LinkedListNode current = node;
		LinkedListNode next;

		while (current != null) {
			next = current.getNext();
			current.setNext(previous);

			previous = current;
			current = next;
		}

		return previous;
	}

	public LinkedListNode reverseAndClone() {
		return reverseAndClone(this);
	}

	private LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;
		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.getValue());
			n.setNext(head);
			head = n;
			node = node.next;
		}
		return head;
	}

	public LinkedListNode isIntersecting(LinkedListNode node) {
		if (node == null) {
			return null;
		}

		LinkedListNode l1 = this;
		LinkedListNode l2 = node;
		int len1 = this.getLength();
		int len2 = node.getLength();

		LinkedListNode shorter = len1 < len2 ? l1 : l2;
		LinkedListNode longer = len1 < len2 ? l2 : l1;

		longer = longer.getKth(Math.abs(len1 - len2));
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		return longer;
	}

	public LinkedListNode getKth(int k) {
		LinkedListNode result = this;
		while (k > 0 && result != null) {
			result = result.next;
			k--;
		}
		return result;
	}

	public LinkedListNode getLast() {
		LinkedListNode result = this;
		while (result.next != null) {
			result = result.next;
		}
		return result;
	}

	public LinkedListNode getLoopStart() {
		return getLoopStart(this);
	}

	private LinkedListNode getLoopStart(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		// find meeting point - it will be LOOP_SIZE - k steps into the linked list
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			boolean isCollision = slow == fast;
			if (isCollision) {
				break;
			}
		}

		// if no meeting point (both cursors are null)
		if (fast == null || fast.next == null) {
			return null;
		}

		// set slow to head, keep fast at the meeting point
		// each are k steps from the loop start
		slow = head;

		// move both at the same pace - they will meet at the loop start
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		// both now point to the start of the loop
		return fast;
	}

	public LinkedListNode findKthLastInOnePass(int k) {
		LinkedListNode current = this;
		LinkedListNode kthLast = this;
		for (int i = 0; i < k; i++) {
			if (current == null) {
				throw new IllegalArgumentException("List doesn't have enough elements");
			}
			current = current.getNext();
		}

		while (current != null) {
			current = current.getNext();
			kthLast = kthLast.getNext();
		}

		return kthLast;
	}

	public LinkedListNode findMiddleInOnePass() {
		LinkedListNode current = this;
		LinkedListNode middle = this;
		int len = 0;

		while (current.getNext() != null) {
			len++;

			if (len % 2 == 0) {
				middle = middle.getNext();
			}

			current = current.getNext();
		}

		if (len % 2 == 1) {
			middle = middle.getNext();
		}

		return middle;
	}
}

package ctci.lists;

import java.util.Stack;

public class Utils {

	/**
	 * CTCI6 2.6
	 */
	public static boolean isPalindromeCloned(LinkedListNode list) {
		LinkedListNode reverse = list.reverseAndClone();
		return list.equals(reverse);
	}

	public static boolean isPalindromeStack(LinkedListNode list) {
		LinkedListNode slow = list;
		LinkedListNode fast = list;

		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.getNext() != null) {
			stack.push(slow.getValue());
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		// for odd skip the middle element
		if (fast != null) {
			slow = slow.getNext();
		}

		while (slow != null) {
			int top = stack.pop();
			if (top != slow.getValue()) {
				return false;
			}
			slow = slow.getNext();
		}

		return true;
	}

	public static boolean isPalindromeRecursive(LinkedListNode list) {
		int len = list.getLength();
		PalindromeResult res = isPalindromeRecursive(list, len);
		return res.result;
	}

	private static PalindromeResult isPalindromeRecursive(LinkedListNode head, int len) {
		boolean evenNodes = (head == null || len <= 0);
		boolean oddNodes = (len == 1);
		if (evenNodes) { 
			return new PalindromeResult(head, true);
		} else if (oddNodes) {
			return new PalindromeResult(head.getNext(), true);
		}
		
		PalindromeResult res = isPalindromeRecursive(head.getNext(), len - 2);
		if (!res.result || res.node == null) {
			return res;
		}
		
		res.result = (head.getValue() == res.node.getValue());
		res.node = res.node.getNext();
		
		return res;
	}

	private static final class PalindromeResult {
		PalindromeResult(LinkedListNode node, boolean result) {
			this.node = node;
			this.result = result;
		}

		LinkedListNode node;
		boolean result;
	}

	/**
	 * CTCI6 2.5 part 2
	 */
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = l1.getLength();
		int len2 = l2.getLength();

		if (len1 > len2) {
			l2 = padList(l2, len1 - len2);
		} else {
			l1 = padList(l1, len2 - len1);
		}

		PartialSum sum = addListsHelper(l1, l2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			return insertBefore(sum.sum, 1);
		}
	}

	private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			return new PartialSum();
		}

		PartialSum sum = addListsHelper(l1.getNext(), l2.getNext());
		int val = l1.getValue() + l2.getValue() + sum.carry;
		LinkedListNode fullResult = insertBefore(sum.sum, val % 10);
		sum.sum = fullResult;
		sum.carry = val / 10;
		return sum;
	}

	private static LinkedListNode padList(LinkedListNode list, int padding) {
		LinkedListNode head = list;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	private static LinkedListNode insertBefore(LinkedListNode head, int i) {
		LinkedListNode node = new LinkedListNode(i);
		if (head != null) {
			node.setNext(head);
		}
		return node;
	}

	/**
	 * Helper class to carry intermediate results
	 */
	private static final class PartialSum {
		LinkedListNode sum = null;
		int carry = 0;
	}

	/**
	 * CTCI6 2.5 part 1
	 */
	public static LinkedListNode addReversedLists(LinkedListNode l1, LinkedListNode l2) {
		return addReversedLists(l1, l2, 0);
	}

	private static LinkedListNode addReversedLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null) {
			value += l1.getValue();
		}
		if (l2 != null) {
			value += l2.getValue();
		}
		result.setValue(value % 10);

		if (l1 != null || l2 != null) {
			LinkedListNode more = addReversedLists(l1 == null ? null : l1.getNext(), l2 == null ? null : l2.getNext(),
					value > 10 ? 1 : 0);
			result.setNext(more);
		}
		return result;
	}

}

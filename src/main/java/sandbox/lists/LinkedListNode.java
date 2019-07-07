package sandbox.lists;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedListNode {

	private int value;
	private LinkedListNode next;

	public LinkedListNode removeDuplicatesInON() {
		Set<Integer> visitedNodes = new HashSet<Integer>();
		visitedNodes.add(this.getValue());
		
		LinkedListNode prev = this, next = this.next;
		while(next != null) {
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
		while(n != null) {
			len++;
			n = n.next;
		}
		
		n = this;
		for(int i = 1; i < (len - kth); i++) {
			n = n.next;
		}
		return n;
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
}

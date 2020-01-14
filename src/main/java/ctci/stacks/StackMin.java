package ctci.stacks;

import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StackMin extends Stack<StackMin.NodeWithMin> {

	private static final long serialVersionUID = 1L;

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().getMin();
		}
	}

	@Data
	@AllArgsConstructor
	public static class NodeWithMin {
		private int value;
		private int min;
	}
}

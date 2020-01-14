package ctci.stacks;

import java.util.Stack;

public class StackMin2 extends Stack<Integer> {
	
	private static final long serialVersionUID = 1L;
	private Stack<Integer> mins = new Stack<Integer>();
	
	public void push(int value) {
		if (value <= min()) {
			mins.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			mins.pop();
		}
		return value;
	}
	
	public int min() {
		if (mins.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return mins.peek();
	}

}

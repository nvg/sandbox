package sandbox.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfStacks extends Stack<Integer> {

	private static final long serialVersionUID = 1L;
	
	private int size;
	private List<Stack<Integer>> stacks = new ArrayList<>();
	
	public StackOfStacks(int size) {
		super();
		this.size = size;
	}

	private Stack<Integer> pushStack() {
		Stack<Integer> result = new Stack<Integer>();
		stacks.add(result);
		return result;
	}
	
	private Stack<Integer> popStack() {
		if (stacks.size() <= 1) {
			return null;
		}
		
		stacks.remove(stacks.size() - 1);
		return getCurrentStack();
	}
	
	private Stack<Integer> getCurrentStack() {
		Stack<Integer> result;
		if (stacks.isEmpty()) {
			result = pushStack();
		} else {
			result = stacks.get(stacks.size() - 1);
		}
		return result;
	}
	
	@Override
	public Integer push(Integer item) {
		Stack<Integer> stack = getCurrentStack();
		boolean isCurrentStackAtCapacity = stack.size() == size;
		if (isCurrentStackAtCapacity) {
			stack = pushStack();
		}
		return stack.push(item);
	}

	@Override
	public synchronized Integer pop() {
		Stack<Integer> stack = getCurrentStack();
		if (stack.isEmpty()) {
			stack = popStack();
		}
		return stack.pop();
	}

	@Override
	public synchronized Integer peek() {
		return getCurrentStack().peek();
	}

	@Override
	public boolean empty() {
		return getCurrentStack().empty();
	}

	@Override
	public synchronized int search(Object o) {
		int offset = 0;
		boolean isFirst = true;
		
		for(int i = stacks.size() - 1; i >= 0; i--) {
			int pos = stacks.get(i).search(o); // fid in 
			
			if (isFirst) {
				boolean isFoundInTheFirstStack = pos != -1; 
				if (isFoundInTheFirstStack) {
					return pos;
				}
				offset = getCurrentStack().size();
				isFirst = false;
			} else {
				if (pos != -1) {
					return offset + pos;
				}
				offset += size;
			}
		}
		return -1;
	}
	
}

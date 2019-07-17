package sandbox.stacks;

import java.util.Stack;

public class StackUtils {

	/**
	 * CTCI6 3.5
	 */
	public static void sort(Stack<Integer> s) {
		// alg with 1 another stack
		Stack<Integer> r = new Stack<Integer>();
		// insert each element in s in sorted order into r
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}

		// copy elements from r back into s
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
		
		// if unlimited stacks are allowed consider using. This requires 2 stacks per each level of 
		//   recursion 
		// quicksort - create two stacks and divive the stack into the two stacks based on a pivot.
		//   The two stacks would be recursively sorted, and them merged back together into the
		//   original stack.
		// mergesort - create two extra stacks and divive the stacks into two parts, recursively 
		//   sort each stack, and then merge them back together in sorted order into the original
		//   stack. 
	}
}

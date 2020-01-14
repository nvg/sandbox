package ctci.stacks;

import java.util.Stack;

public class MyQueue2<T> {

	// naive implementation with re-shuffling each time 
	// b/w stacks for any operation except add
	
    private Stack<T> s1 = new Stack<>(); // keeps up-to-date content
    private Stack<T> s2 = new Stack<>(); // used for retrieving "oldest" element

    public int size() {
        return s1.size();
    }
    
    public void add(T value) {
        s1.push(value);
    }

    public T peek() {
    	shift(s1, s2);
    	T result = s2.peek();
    	shift(s2, s1);
    	
        return result; 
    }
    
    private void shift(Stack<T> s1, Stack<T> s2) {
    	while(!s1.isEmpty()) {
    		s2.push(s1.pop());
    	}    	
    }

    public T remove() {
    	shift(s1, s2);
    	T result = s2.pop();
    	shift(s2, s1);
    	
        return result; 
    }
    
}

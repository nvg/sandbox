package ctci.stacks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ctci.stacks.MyQueue;

public class MyQueueTest {

    @Test
    public void shouldWorksAsAQueue() {
        MyQueue<Integer> q = new MyQueue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        assertEquals(1, q.remove());
        assertEquals(2, q.peek());
        assertEquals(2, q.remove());
        assertEquals(3, q.peek());
        assertEquals(3, q.remove());
        assertEquals(4, q.remove());
        
        q.add(4);
        assertEquals(5, q.remove());
        assertEquals(4, q.remove());
    }

}

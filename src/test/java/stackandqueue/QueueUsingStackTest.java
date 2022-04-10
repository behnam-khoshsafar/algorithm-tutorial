package stackandqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueUsingStackTest {

    @Test
    public void createQueue() {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
    }

    @Test
    public void pushOneItem() {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
        assertTrue(queue.push(10));
        assertEquals(10, queue.peek());
    }

    @Test
    public void pushMultipleItem() {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
        assertTrue(queue.push(10));
        assertTrue(queue.push(20));
        assertEquals(10, queue.peek());
    }

    @Test
    public void peekFromEmptyQueue() {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
        assertThrows(EmptyQueueException.class, queue::peek);
    }

    @Test
    public void removeItem() {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
        assertTrue(queue.push(10));
        assertTrue(queue.push(20));
        assertEquals(10, queue.remove());
    }

    @Test
    public void removeItemFromEmptyQueue() {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
        assertThrows(EmptyQueueException.class, queue::remove);
    }

    @Test
    public void removeItemBetweenMultiplePush() {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
        assertTrue(queue.push(10));
        assertTrue(queue.push(20));
        assertEquals(10, queue.remove());
        assertTrue(queue.push(30));
        assertTrue(queue.push(40));
        assertEquals(20, queue.remove());
    }
}
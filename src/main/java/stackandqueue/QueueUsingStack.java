package stackandqueue;

import java.util.Stack;

public class QueueUsingStack<E> {

    private final Stack<E> stack;
    private final Stack<E> queue;

    public QueueUsingStack() {
        this.stack = new Stack<>();
        this.queue = new Stack<>();
    }

    public boolean push(E i) {
        stack.push(i);
        return true;
    }

    public E peek() {
        shiftItems();
        if (queue.isEmpty())
            throw new EmptyQueueException();
        return queue.peek();
    }

    private void shiftItems() {
        if (queue.isEmpty())
            while (!stack.empty())
                queue.push(stack.pop());
    }

    public E remove() {
        shiftItems();
        if (queue.isEmpty())
            throw new EmptyQueueException();
        return queue.pop();
    }
}

package stackandqueue;

import java.util.Stack;

public class SortedStack<E extends Comparable<E>> {
    private int size;
    private final Stack<E> stack;

    public SortedStack() {
        stack = new Stack<>();
    }

    public E push(E i) {
        size++;
        if (stack.empty() || i.compareTo(peek()) < 0) {
            stack.push(i);
            return i;
        }
        sortStack(i);
        return i;
    }

    private void sortStack(E i) {
        Stack<E> temp = new Stack<>();
        while (!stack.empty() && stack.peek().compareTo(i) < 0)
            temp.push(stack.pop());
        stack.push(i);
        while (!temp.empty())
            stack.push(temp.pop());
    }

    public int size() {
        return size;
    }

    public E peek() {
        return stack.peek();
    }
}

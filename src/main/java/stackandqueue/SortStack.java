package stackandqueue;

import java.util.Stack;

public class SortStack<E extends Comparable<E>> {

    public void sort(Stack<E> stack) {
        if (stack.empty() || stack.size() == 1)
            return;
        Stack<E> tempStack = new Stack<>();
        while (!stack.empty()) {
            E item = stack.pop();
            while (!tempStack.empty() && item.compareTo(tempStack.peek()) < 0) {
                stack.push(tempStack.pop());
            }
            tempStack.push(item);
        }
        while (!tempStack.empty())
            stack.push(tempStack.pop());
    }

}

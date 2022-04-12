package stackandqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class SortStackTest {

    @Test
    public void sortStackWithOneItem() {
        SortStack<Integer> sortStack = new SortStack<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        sortStack.sort(stack);
        Assertions.assertEquals(1, stack.peek());
    }

    @Test
    public void sortStackWithTwoItem() {
        SortStack<Integer> sortStack = new SortStack<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        sortStack.sort(stack);
        Assertions.assertEquals(2, stack.peek());
    }

}
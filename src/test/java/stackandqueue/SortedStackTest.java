package stackandqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedStackTest {

    @Test
    public void pushOneItem() {
        SortedStack<Integer> sortStack = new SortedStack<>();

        sortStack.push(5);

        assertEquals(1, sortStack.size());
        assertEquals(5, sortStack.peek());
    }

    @Test
    public void pushTwoSortedItem() {
        SortedStack<Integer> sortStack = new SortedStack<>();

        sortStack.push(5);
        sortStack.push(4);

        assertEquals(2, sortStack.size());
        assertEquals(4, sortStack.peek());
    }

    @Test
    public void pushTwoUnSortedItem() {
        SortedStack<Integer> sortStack = new SortedStack<>();

        assertEquals(4, sortStack.push(4));
        assertEquals(5, sortStack.push(5));

        assertEquals(2, sortStack.size());
        assertEquals(4, sortStack.peek());
    }

}
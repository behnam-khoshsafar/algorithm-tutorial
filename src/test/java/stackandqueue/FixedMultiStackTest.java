package stackandqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedMultiStackTest {

    @Test
    public void createStack() {
        FixedMultiStack<Integer> fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 10);
        assertEquals(3, fixedMultiStack.getNumberOfStacks());
        assertEquals(10, fixedMultiStack.getStackCapacity());
    }

    @Test
    public void pushOneItem() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 10);
        int value = 10;
        int stackNumber = 1;
        assertTrue(fixedMultiStack.push(value, stackNumber));
        assertEquals(value, fixedMultiStack.peek(stackNumber));
        assertEquals(1, fixedMultiStack.getStackSize(stackNumber));
    }

    @Test
    public void pushOneItemToSecondStack() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 10);
        assertTrue(fixedMultiStack.push(10, 2));
        assertEquals(10, fixedMultiStack.peek(2));
        assertEquals(1, fixedMultiStack.getStackSize(2));
    }

    @Test
    public void pushMultipleItem() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 10);
        int stackNumber = 1;
        assertTrue(fixedMultiStack.push(10, stackNumber));
        assertTrue(fixedMultiStack.push(20, stackNumber));
        assertEquals(20, fixedMultiStack.peek(stackNumber));
        assertEquals(2, fixedMultiStack.getStackSize(stackNumber));
    }

    @Test
    public void itemExceedsTheStackSize() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 2);
        int stackNumber = 1;
        assertTrue(fixedMultiStack.push(10, stackNumber));
        assertTrue(fixedMultiStack.push(20, stackNumber));
        assertThrows(FullStackException.class, () -> fixedMultiStack.push(30, stackNumber));
        assertEquals(20, fixedMultiStack.peek(stackNumber));
        assertEquals(2, fixedMultiStack.getStackSize(stackNumber));
    }

    @Test
    public void popOneItem() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 2);
        int stackNumber = 1;
        assertTrue(fixedMultiStack.push(10, stackNumber));
        assertTrue(fixedMultiStack.push(20, stackNumber));
        assertEquals(20, fixedMultiStack.pop(stackNumber));
        assertEquals(1, fixedMultiStack.getStackSize(stackNumber));
        assertEquals(10, fixedMultiStack.peek(stackNumber));
    }

    @Test
    public void popFromEmptyStack() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 2);
        int stackNumber = 1;
        assertThrows(EmptyStackException.class, () -> fixedMultiStack.pop(stackNumber));
    }

    @Test
    public void peekFromEmptyStack() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 2);
        int stackNumber = 1;
        assertThrows(EmptyStackException.class, () -> fixedMultiStack.peek(stackNumber));
    }

    @Test
    public void popOneItemFromSecondStack() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 2);
        int stackNumber = 2;
        assertTrue(fixedMultiStack.push(10, stackNumber));
        assertTrue(fixedMultiStack.push(20, stackNumber));
        assertEquals(20, fixedMultiStack.pop(stackNumber));
        assertEquals(1, fixedMultiStack.getStackSize(stackNumber));
        assertEquals(10, fixedMultiStack.peek(stackNumber));
    }

    @Test
    public void popMultipleItem() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 4);
        int stackNumber = 1;
        assertTrue(fixedMultiStack.push(10, stackNumber));
        assertTrue(fixedMultiStack.push(20, stackNumber));
        assertTrue(fixedMultiStack.push(30, stackNumber));
        assertEquals(30, fixedMultiStack.pop(stackNumber));
        assertEquals(20, fixedMultiStack.pop(stackNumber));
        assertEquals(1, fixedMultiStack.getStackSize(stackNumber));
        assertEquals(10, fixedMultiStack.peek(stackNumber));
    }

    @Test
    public void popMultipleItemToSecondStack() {
        FixedMultiStack<Integer>  fixedMultiStack = new FixedMultiStack<>(Integer.class, 3, 4);
        int stackNumber = 2;
        assertTrue(fixedMultiStack.push(10, stackNumber));
        assertTrue(fixedMultiStack.push(20, stackNumber));
        assertTrue(fixedMultiStack.push(30, stackNumber));
        assertEquals(30, fixedMultiStack.pop(stackNumber));
        assertEquals(20, fixedMultiStack.pop(stackNumber));
        assertEquals(1, fixedMultiStack.getStackSize(stackNumber));
        assertEquals(10, fixedMultiStack.peek(stackNumber));
    }
}
package stackandqueue;

import java.lang.reflect.Array;

public class FixedMultiStack<E> {
    private final int numberOfStacks;
    private final int stackCapacity;
    private final E[] values;
    private final int[] sizes;

    public FixedMultiStack(Class<E> clazz, int numberOfStacks, int stackCapacity) {
        this.numberOfStacks = numberOfStacks;
        this.stackCapacity = stackCapacity;
        values = (E[]) Array.newInstance(clazz, stackCapacity * numberOfStacks);
        sizes = new int[numberOfStacks];
    }

    public int getNumberOfStacks() {
        return numberOfStacks;
    }

    public int getStackCapacity() {
        return stackCapacity;
    }

    public boolean push(E value, int stackNumber) {
        if (getStackSize(stackNumber) == stackCapacity)
            throw new FullStackException("Stack is full");
        increaseStackLength(stackNumber);
        values[getTopItemIndex(stackNumber)] = value;
        return true;
    }

    private void increaseStackLength(int stackNumber) {
        sizes[stackNumber - 1]++;
    }

    public E peek(int stackNumber) {
        if (isEmpty(stackNumber))
            throw new EmptyStackException();
        return values[getTopItemIndex(stackNumber)];
    }

    private boolean isEmpty(int stackNumber) {
        return getTopItemIndex(stackNumber) < 0;
    }

    private int getTopItemIndex(int stackNumber) {
        return getStackSize(stackNumber) - 1;
    }

    public int getStackSize(int stackNumber) {
        return sizes[stackNumber - 1];
    }

    public E pop(int stackNumber) {
        if (isEmpty(stackNumber))
            throw new EmptyStackException();
        int itemIndex = getTopItemIndex(stackNumber);
        E value = values[itemIndex];
        values[itemIndex] = null;
        decreaseStackLength(stackNumber);
        return value;
    }

    private void decreaseStackLength(int stackNumber) {
        sizes[stackNumber - 1]--;
    }
}

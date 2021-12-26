package sort.impl;

import sort.Sort;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] items) {
        if (items == null || items.length <= 1)
            return items;
        for (var i = 0; i < items.length; i++) {
            int minItemIndex = findSmallestItemIndex(items, i);
            swap(items, i, minItemIndex);
        }
        return items;
    }

    private int findSmallestItemIndex(T[] items, int minItemIndex) {
        for (var i = minItemIndex + 1; i < items.length; i++) {
            if (items[i].compareTo(items[minItemIndex]) < 0)
                minItemIndex = i;
        }
        return minItemIndex;
    }

    private void swap(T[] items, int swapIndex, int minItemIndex) {
        if (swapIndex != minItemIndex) {
            T temp = items[swapIndex];
            items[swapIndex] = items[minItemIndex];
            items[minItemIndex] = temp;
        }
    }
}

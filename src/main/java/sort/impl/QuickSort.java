package sort.impl;

import sort.Sort;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] items) {
        if (items == null || items.length <= 1)
            return items;
        sort(items, 0, items.length - 1);
        return items;
    }

    private void sort(T[] items, int left, int right) {
        if (left >= right)
            return;
        int pivot = partition(items, left, right);
        sort(items, left, pivot - 1);
        sort(items, pivot + 1, right);
    }

    private int partition(T[] items, int left, int right) {
        int boundary = left - 1;
        for (int i = left; i <= right; i++) {
            if (items[i].compareTo(items[right]) <= 0)
                swap(items, ++boundary, i);
        }
        return boundary;
    }

    private void swap(T[] items, int index1, int index2) {
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}

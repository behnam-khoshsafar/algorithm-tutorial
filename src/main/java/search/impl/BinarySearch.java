package search.impl;

import search.Search;

import java.util.Optional;

public class BinarySearch<T extends Comparable<T>> implements Search<T> {

    @Override
    public Optional<Integer> find(T[] items, T item) {
        return recFind(items, item);
    }

    public Optional<Integer> recFind(T[] items, T item) {
        if (items == null || items.length == 0 || item == null)
            return Optional.empty();
        int left = 0;
        int right = items.length - 1;
        return recFind(items, item, left, right);
    }

    private Optional<Integer> recFind(T[] items, T item, int left, int right) {
        if (left > right)
            return Optional.empty();
        int length = right - left + 1;
        int mid = length / 2 + left;
        var midValue = items[mid];
        if (midValue.equals(item))
            return Optional.of(mid);
        else if (midValue.compareTo(item) < 0)
            return recFind(items, item, mid + 1, right);
        else
            return recFind(items, item, left, mid - 1);
    }

    private Optional<Integer> simpleFind(T[] items, T item) {
        if (items == null || items.length == 0 || item == null)
            return Optional.empty();
        int left = 0;
        int right = items.length - 1;
        int length = items.length;
        do {
            int mid = length / 2 + left;
            var midElement = items[mid];
            if (midElement.equals(item))
                return Optional.of(mid);
            else if (midElement.compareTo(item) < 0)
                left = mid + 1;
            else
                right = mid - 1;
            length = right - left + 1;
        } while (left <= right);
        return Optional.empty();
    }
}

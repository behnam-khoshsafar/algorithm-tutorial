package sort.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.Sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortTest {

    private Sort<Integer> sort;
    private Integer[] items;

    @BeforeEach
    public void init() {
        sort = new QuickSort<>();
        items = new Integer[]{12, 13, 14, 15, 6, 5, 7, 11, 16, 17, 18, 8, 9, 10, 30, 35, 67, 86, 1, 2, 200, 3, 4};
    }

    @Test
    void shouldReturnNullWhenInputIsNull() {
        Assertions.assertNull(sort.sort(null));
    }

    @Test
    void shouldReturnEmptyWhenInputIsEmpty() {
        Integer[] items = new Integer[0];
        assertEquals(items, sort.sort(items));
    }

    @Test
    void shouldWorkCorrectlyWhenThereIsOneValue() {
        Integer[] items = {1};
        assertEquals(items, sort.sort(items));
    }

    @Test
    void shouldSortCorrectly() {
        Integer[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 30, 35, 67, 86, 200};
        assertArrayEquals(result, sort.sort(items));
    }
}
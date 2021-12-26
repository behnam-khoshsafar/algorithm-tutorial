package search.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import search.Search;
import search.impl.BinarySearch;

import java.util.Optional;

class BinarySearchTest {

    private Search<Integer> search;
    private Integer[] elements;

    @BeforeEach
    public void init() {
        search = new BinarySearch<>();
        elements = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 30, 35, 67, 86, 200};
    }

    @Test
    public void shouldReturnEmptyWhenInputIsEmpty() {
        Assertions.assertEquals(Optional.empty(), search.find(null, 10));
        Assertions.assertEquals(Optional.empty(), search.find(elements, null));
    }

    @Test
    public void shouldReturnEmptyWhenElementIsNotIntTheInput() {
        Assertions.assertEquals(Optional.empty(), search.find(elements, 400));
    }

    @Test
    public void shouldReturnCorrectIndex() {
        Assertions.assertEquals(Optional.of(22), search.find(elements, 200));
        Assertions.assertEquals(Optional.of(10), search.find(elements, 11));
        Assertions.assertEquals(Optional.of(18), search.find(elements, 30));
        Assertions.assertEquals(Optional.of(0), search.find(elements, 1));
    }
}
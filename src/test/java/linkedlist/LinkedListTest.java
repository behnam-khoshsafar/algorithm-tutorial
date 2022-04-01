package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static linkedlist.LinkedList.removeDuplicate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinkedListTest {

    @Test
    public void shouldHandleNullValue() {
        List<Integer> list = null;
        removeDuplicate(list);
        assertNull(list);
    }

    @Test
    public void shouldHandleEmptyValue() {
        List<Integer> list = new ArrayList<>();
        removeDuplicate(list);
        assertEquals(0, list.size());
    }

    @Test
    public void shouldRemoveDuplicates() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(10);

        removeDuplicate(list);

        assertEquals(List.of(1, 2, 3, 6, 7, 9, 10, 11, 12), list);
    }
}
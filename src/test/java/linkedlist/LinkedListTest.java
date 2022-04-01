package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static linkedlist.LinkedList.*;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void removeDuplicateShouldHandleNullValue() {
        List<Integer> list = null;
        removeDuplicate(list);
        assertNull(list);
    }

    @Test
    public void removeDuplicateShouldHandleEmptyValue() {
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

    @Test
    public void KthToLastShouldReturnEmptyForNullInput() {
        assertNull(KthToLast(null, 1));
    }

    @Test
    public void KthToLastShouldReturnEmptyForInvalidKth() {
        LinkedListNode<Integer> listNode = new LinkedListNode<>(2, null);
        assertNull(KthToLast(listNode, 5));
    }

    @Test
    public void KthToLastShouldReturnCorrectResult1() {
        LinkedListNode<Integer> listNode = new LinkedListNode<>(2, null);
        assertEquals(2, KthToLast(listNode, 1));
    }

    @Test
    public void KthToLastShouldReturnCorrectResult2() {
        LinkedListNode<Integer> listNode4 = new LinkedListNode<>(4, null);
        LinkedListNode<Integer> listNode2 = new LinkedListNode<>(2, listNode4);
        assertEquals(2, KthToLast(listNode2, 2));
    }

    @Test
    public void KthToLastShouldReturnCorrectResult3() {
        LinkedListNode<Integer> listNode4 = new LinkedListNode<>(4, null);
        LinkedListNode<Integer> listNode2 = new LinkedListNode<>(2, listNode4);
        assertEquals(4, KthToLast(listNode2, 1));
    }

    @Test
    public void deleteNodeShouldDeleteCorrectValue() {
        LinkedListNode<Integer> listNode9 = new LinkedListNode<>(9, null);
        LinkedListNode<Integer> listNode8 = new LinkedListNode<>(8, listNode9);
        LinkedListNode<Integer> listNode7 = new LinkedListNode<>(7, listNode8);
        LinkedListNode<Integer> listNode4 = new LinkedListNode<>(4, listNode7);
        LinkedListNode<Integer> listNode2 = new LinkedListNode<>(2, listNode4);

        assertTrue(deleteNode(listNode4));
        assertEquals(listNode4.getNext(), listNode8);
        assertEquals(listNode7.getData(),listNode4.getData());
    }

    @Test
    public void deleteNodeShouldDeleteFirstItem() {
        LinkedListNode<Integer> listNode9 = new LinkedListNode<>(9, null);
        LinkedListNode<Integer> listNode8 = new LinkedListNode<>(8, listNode9);
        LinkedListNode<Integer> listNode7 = new LinkedListNode<>(7, listNode8);
        LinkedListNode<Integer> listNode4 = new LinkedListNode<>(4, listNode7);
        LinkedListNode<Integer> listNode2 = new LinkedListNode<>(2, listNode4);

        assertTrue(deleteNode(listNode2));
        assertEquals(listNode2.getNext(), listNode4.getNext());
        assertEquals(listNode2.getData(),listNode4.getData());
    }

    @Test
    public void deleteNodeShouldDeleteLastItem() {
        LinkedListNode<Integer> listNode9 = new LinkedListNode<>(9, null);
        LinkedListNode<Integer> listNode8 = new LinkedListNode<>(8, listNode9);
        LinkedListNode<Integer> listNode7 = new LinkedListNode<>(7, listNode8);
        LinkedListNode<Integer> listNode4 = new LinkedListNode<>(4, listNode7);
        LinkedListNode<Integer> listNode2 = new LinkedListNode<>(2, listNode4);

        assertFalse(deleteNode(listNode9));
    }
}
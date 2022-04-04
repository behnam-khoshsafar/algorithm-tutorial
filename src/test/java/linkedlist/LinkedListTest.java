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
        assertEquals(listNode7.getData(), listNode4.getData());
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
        assertEquals(listNode2.getData(), listNode4.getData());
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

    @Test
    public void partitionShouldHandleEmptyValue() {
        LinkedListNode<Integer> listNode = null;
        assertNull(partition(listNode, 2));
    }

    @Test
    public void partitionShouldHandleListWithOneElement() {
        LinkedListNode<Integer> listNode = new LinkedListNode<>(1, null);
        LinkedListNode<Integer> partition = partition(listNode, 2);
        assertNull(partition.getNext());
        assertEquals(1, partition.getData());
    }

    @Test
    public void shouldPartitionCorrectly() {
        LinkedListNode<Integer> tail = new LinkedListNode<>(1, null);
        LinkedListNode<Integer> listNode2 = new LinkedListNode<>(2, tail);
        LinkedListNode<Integer> listNode3 = new LinkedListNode<>(10, listNode2);
        LinkedListNode<Integer> listNode4 = new LinkedListNode<>(5, listNode3);
        LinkedListNode<Integer> listNode5 = new LinkedListNode<>(8, listNode4);
        LinkedListNode<Integer> listNode6 = new LinkedListNode<>(5, listNode5);
        LinkedListNode<Integer> head = new LinkedListNode<>(3, listNode6);

        LinkedListNode<Integer> partition = partition(head, 5);

        assertEquals(1, partition.getData());
    }

    @Test
    public void sumListShouldReturnCorrectResult() {
        LinkedListNode<Integer> firstNumberTail = new LinkedListNode<>(6, null);
        LinkedListNode<Integer> firstNumberMiddle = new LinkedListNode<>(1, firstNumberTail);
        LinkedListNode<Integer> firstNumberHead = new LinkedListNode<>(7, firstNumberMiddle);

        LinkedListNode<Integer> secondNumberTail = new LinkedListNode<>(2, null);
        LinkedListNode<Integer> secondNumberMiddle = new LinkedListNode<>(9, secondNumberTail);
        LinkedListNode<Integer> secondNumberHead = new LinkedListNode<>(5, secondNumberMiddle);

        LinkedListNode<Integer> resultNode = sumList(firstNumberHead, secondNumberHead);

        assertEquals(2, resultNode.getData());
        assertEquals(1, resultNode.getNext().getData());
        assertEquals(9, resultNode.getNext().getNext().getData());
        assertNull(resultNode.getNext().getNext().getNext());
    }

    @Test
    public void sumListShouldReturnCorrectResultWithOneElement() {
        LinkedListNode<Integer> firstNumberHead = new LinkedListNode<>(7, null);

        LinkedListNode<Integer> secondNumberTail = new LinkedListNode<>(2, null);
        LinkedListNode<Integer> secondNumberMiddle = new LinkedListNode<>(9, secondNumberTail);
        LinkedListNode<Integer> secondNumberHead = new LinkedListNode<>(5, secondNumberMiddle);

        LinkedListNode<Integer> resultNode = sumList(firstNumberHead, secondNumberHead);

        assertEquals(2, resultNode.getData());
        assertEquals(0, resultNode.getNext().getData());
        assertEquals(3, resultNode.getNext().getNext().getData());
        assertNull(resultNode.getNext().getNext().getNext());
    }

    @Test
    public void isPalindromeEmptyInput() {
        LinkedListNode<Integer> head = null;

        assertFalse(LinkedList.isPalindrome(head));
    }

    @Test
    public void isPalindrome() {
        LinkedListNode<Integer> listNode3 = new LinkedListNode<>(0, null);
        LinkedListNode<Integer> listNode4 = new LinkedListNode<>(1, listNode3);
        LinkedListNode<Integer> listNode5 = new LinkedListNode<>(2, listNode4);
        LinkedListNode<Integer> listNode6 = new LinkedListNode<>(1, listNode5);
        LinkedListNode<Integer> head = new LinkedListNode<>(0, listNode6);

        assertTrue(LinkedList.isPalindrome(head));
    }

    @Test
    public void isPalindrome2() {
        LinkedListNode<Integer> listNode4 = new LinkedListNode<>(1, null);
        LinkedListNode<Integer> listNode5 = new LinkedListNode<>(2, listNode4);
        LinkedListNode<Integer> listNode6 = new LinkedListNode<>(1, listNode5);
        LinkedListNode<Integer> head = new LinkedListNode<>(0, listNode6);

        assertFalse(LinkedList.isPalindrome(head));
    }
}
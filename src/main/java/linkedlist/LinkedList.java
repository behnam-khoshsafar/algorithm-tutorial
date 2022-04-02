package linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinkedList {

    public static <E> void removeDuplicate(List<E> list) {
        if (list == null || list.isEmpty())
            return;
        Set<E> tempSet = new HashSet<>();
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (tempSet.contains(next))
                iterator.remove();
            tempSet.add(next);
        }
    }

    public static <E extends Comparable<E>> E KthToLast(LinkedListNode<E> linkedListNode, int k) {
        if (linkedListNode == null)
            return null;

        LinkedListNode<E> p1 = linkedListNode;
        LinkedListNode<E> p2 = linkedListNode;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.getNext();
        }

        while (p1 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p2.getData();
    }

    public static <E extends Comparable<E>> boolean deleteNode(LinkedListNode<E> node) {
        if (node == null || node.getNext() == null)
            return false;
        LinkedListNode<E> next = node.getNext();
        node.setNext(next.getNext());
        node.setData(next.getData());
        return true;
    }

    public static <E extends Comparable<E>> LinkedListNode<E> partition(LinkedListNode<E> node, E value) {
        if (node == null)
            return null;
        if (node.getNext() == null)
            return node;
        LinkedListNode<E> head = node;
        LinkedListNode<E> tail = node;
        while (node != null) {
            LinkedListNode<E> next = node.getNext();
            if (node.getData().compareTo(value) < 0) {
                node.setNext(head);
                head = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        tail.setNext(null);
        return head;
    }
}
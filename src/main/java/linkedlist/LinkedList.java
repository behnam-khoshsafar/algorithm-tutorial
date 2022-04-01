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

    public static <E> E KthToLast(LinkedListNode<E> linkedListNode, int k) {
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

    public static <E> boolean deleteNode(LinkedListNode<E> node) {
        if (node == null || node.getNext() == null)
            return false;
        LinkedListNode<E> next = node.getNext();
        node.setNext(next.getNext());
        node.setData(next.getData());
        return true;
    }
}
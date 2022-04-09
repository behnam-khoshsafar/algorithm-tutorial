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

    public static LinkedListNode<Integer> sumList(LinkedListNode<Integer> firstNumber, LinkedListNode<Integer> secondNumber) {
        if (firstNumber == null || secondNumber == null)
            return null;
        Integer first = convertReversedListToNumber(firstNumber);
        Integer second = convertReversedListToNumber(secondNumber);
        Integer result = first + second;
        return convertNumberToReversedList(result);
    }

    private static LinkedListNode<Integer> convertNumberToReversedList(Integer number) {
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        while (number > 0) {
            int remainder = number % 10;
            number /= 10;
            LinkedListNode<Integer> next = new LinkedListNode<>(remainder, null);
            if (head == null) {
                head = next;
                tail = next;
            } else {
                tail.setNext(next);
                tail = next;
            }
        }
        return head;
    }

    private static Integer convertReversedListToNumber(LinkedListNode<Integer> numberNode) {
        LinkedListNode<Integer> num = numberNode;
        int counter = 0;
        int number = 0;
        while (num != null) {
            number = num.getData() * (int) Math.pow(10, counter) + number;
            counter++;
            num = num.getNext();
        }
        return number;
    }

    public static <E extends Comparable<E>> boolean isPalindrome(LinkedListNode<E> node) {
        if (node == null)
            return false;
        LinkedListNode<E> reversedItems = reverseList(node);
        return isEqual(node, reversedItems);
    }

    private static <E extends Comparable<E>> LinkedListNode<E> reverseList(LinkedListNode<E> node) {
        LinkedListNode<E> head = null;
        while (node != null) {
            LinkedListNode<E> n = new LinkedListNode<>(node.getData(), null);
            n.setNext(head);
            head = n;
            node = node.getNext();
        }
        return head;
    }

    private static <E extends Comparable<E>> boolean isEqual(LinkedListNode<E> firstNode, LinkedListNode<E> secondNode) {
        while (firstNode != null && secondNode != null) {
            if (!firstNode.getData().equals(secondNode.getData()))
                return false;
            firstNode = firstNode.getNext();
            secondNode = secondNode.getNext();
        }
        return firstNode == null && secondNode == null;
    }

    public static <E extends Comparable<E>> LinkedListNode<E> intersect(LinkedListNode<E> firstNode, LinkedListNode<E> secondNode) {
        LinkedListDetails<E> firstDetails = getTailAndSize(firstNode);
        LinkedListDetails<E> secondDetails = getTailAndSize(secondNode);
        if (firstDetails.getTail() != secondDetails.getTail())
            return null;

        LinkedListNode<E> shorter = firstDetails.getSize() < secondDetails.getSize() ? firstNode : secondNode;
        LinkedListNode<E> longer = firstDetails.getSize() > secondDetails.getSize() ? firstNode : secondNode;

        longer = getKthNode(longer, Math.abs(firstDetails.getSize() - secondDetails.getSize()));

        while (shorter != longer) {
            shorter = shorter.getNext();
            longer = longer.getNext();
        }
        return longer;
    }

    private static <E extends Comparable<E>> LinkedListNode<E> getKthNode(LinkedListNode<E> node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.getNext();
        }
        return node;
    }

    private static <E extends Comparable<E>> LinkedListDetails<E> getTailAndSize(LinkedListNode<E> node) {
        int counter = 1;
        while (node.getNext() != null) {
            node = node.getNext();
            counter++;
        }
        return new LinkedListDetails<>(counter, node);
    }

    public static <E extends Comparable<E>> LinkedListNode<E> getStartOfLoop(LinkedListNode<E> node) {
        if (node == null || node.getNext() == null)
            return null;
        LinkedListNode<E> slowRunner = node;
        LinkedListNode<E> fastRunner = node;
        while (fastRunner != null && fastRunner.getNext() != null) {
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext().getNext();
            if (slowRunner == fastRunner) {
                break;
            }
        }

        if (fastRunner == null || fastRunner.getNext() == null)
            return null;

        slowRunner = node;
        while (slowRunner != fastRunner) {
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext();
        }

        return slowRunner;
    }

    private static class LinkedListDetails<E extends Comparable<E>> {
        private final int size;
        private final LinkedListNode<E> tail;

        public LinkedListDetails(int size, LinkedListNode<E> tail) {
            this.size = size;
            this.tail = tail;
        }

        public int getSize() {
            return size;
        }

        public LinkedListNode<E> getTail() {
            return tail;
        }
    }
}
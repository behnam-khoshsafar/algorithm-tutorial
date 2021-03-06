package linkedlist;

public class LinkedListNode<E extends Comparable<E>> {
    private E data;
    private LinkedListNode<E> next;

    public LinkedListNode(E data, LinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public void setNext(LinkedListNode<E> node) {
        this.next = node;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public LinkedListNode<E> getNext() {
        return next;
    }
}

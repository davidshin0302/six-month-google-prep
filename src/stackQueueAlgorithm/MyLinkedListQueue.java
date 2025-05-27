package stackQueueAlgorithm;

import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void offer(E element) {
        Node<E> newNode = new Node<E>(element);

        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E poll() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }

        E dataToReturn = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return dataToReturn;
    }

    public E peek() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            return head.data;
        }
    }

    public boolean isEmpty() {
        boolean isEmpty = false;
        if (size == 0) {
            isEmpty = true;
        }

        return isEmpty;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}

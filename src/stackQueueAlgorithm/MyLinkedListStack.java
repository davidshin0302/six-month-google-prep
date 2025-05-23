package stackQueueAlgorithm;

import java.util.NoSuchElementException;

public class MyLinkedListStack<E> {
    private Node<E> head;
    private int size;

    public MyLinkedListStack() {
        this.head = null;
        this.size = 0;
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);

        newNode.next = head;
        head = newNode;
        size++;
    }

    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty.");
        }

        E dataToReturn = head.data;
        head = head.next;
        size--;

        System.out.println(dataToReturn);
        return dataToReturn;
    }

    public E peek() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return head.data;
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

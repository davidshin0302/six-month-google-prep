package stackQueueAlgorithm;

public class MyLinkedListQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void offer(E element){
        Node<E> newNode = new Node<E>((E) element);
    }

    public E poll(){
        return null;
    }

    public E peek(){
        return null;
    }

    public boolean isEmpty(){
        return false;
    }

    public int size(){
        return size;
    }
}

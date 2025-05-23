package stackQueueAlgorithm;

import java.util.NoSuchElementException;

public class MyCircularArrayQueue<E> {
    private E[] data;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public MyCircularArrayQueue(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = (E[]) new Object[initialCapacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void offer(E element) {
        if (size == capacity) {
            throw new StackOverflowError("Queue is full");
        }

        data[rear] = element;
        rear = (rear + 1) % capacity;
        size++;
    }

    public E poll() {
        if(size == 0){
            throw new NoSuchElementException("Queue is Empty");
        }

        E temp = data[front];
        front = (front + 1) % capacity;
        size--;

        return temp;
    }

    public E peek() {
        if(size == 0){
            throw new NoSuchElementException("Queue is Empty");
        }

        System.out.println(data[front]);
        return data[front];
    }

    public boolean isEmpty() {
        boolean isEmpty = false;
        if(size == 0){
            isEmpty = true;
        }
        return isEmpty;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        if(size == capacity){
            return true;
        }else{
            return false;
        }
    }
}

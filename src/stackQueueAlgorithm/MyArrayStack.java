package stackQueueAlgorithm;

import java.util.ArrayList;

public class MyArrayStack<E> {
    private E[] data;
    private int top;
    private int capacity;

    public MyArrayStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = (E[]) new Object[initialCapacity];
        this.top = 0;
    }

    public void push(E element) {
        if (top == (capacity - 1)) {
            System.out.println("List if full");
        }
    }
}

package stackQueueAlgorithm;

import java.util.ArrayList;

public class MyArrayStack<E> {
    private E[] data;
    private int top;
    private int capacity;

    public MyArrayStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = (E[]) new Object[initialCapacity];
        this.top = -1;
    }

    public void push(E element) {
        if (top == (capacity - 1)) {
            System.out.println("Stack is over flow");
        } else {
            top++;
            data[top] = element;
        }
    }

    public E pop() {
        if (top < 0) {
            System.out.println("Currently List is empty");
            return null;
        }else{
            E temp = data[top];
            data[top] = null;
            top--;
            System.out.println(temp);
            return temp;
        }
    }

    public E peek() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }
}

package com.collections;

import java.util.Arrays;

public class MyQueue<T> {
    private T[] elements;
    private int size;

    public MyQueue() {
        elements = initialize(2);
    }

    public MyQueue(int capacity) {
        elements = initialize(capacity);
    }

    public void add(T element) {
        if (isFull())
            elements = Arrays.copyOf(elements, size * 2);

        elements[size++] = element;
    }

    public T poll() {
        T value = peek();

        elements = removeFirst();
        size--;

        return value;
    }

    public T peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return elements[0];
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            elements[i] = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == elements.length;
    }

    private T[] initialize(int capacity) {
        return (T[]) new Object[capacity];
    }

    private T[] removeFirst() {
        T[] newElements = initialize(elements.length);
        for (int i = 1, j = 0; i < size; i++, j++)
            newElements[j] = elements[i];

        return newElements;
    }

    public T[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}

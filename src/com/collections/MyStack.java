package com.collections;

import java.util.Arrays;

public class MyStack<T> {
    private T[] elements;
    private int size;

    public MyStack() {
        elements = initialize(2);
    }

    public MyStack(int capacity) {
        elements = initialize(capacity);
    }

    public void push(T element) {
        if (isFull())
            elements = Arrays.copyOf(elements, size * 2);

        elements[size++] = element;
    }

    public T remove(int index) {
        checkIndex(index);
        T value = elements[index];

        elements = fastRemove(index);
        size--;

        return value;
    }

    public T pop() {
        T value = peek();

        elements = removeLast();
        size--;

        return value;
    }

    public T peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return elements[size - 1];
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

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    private T[] initialize(int capacity) {
        return (T[]) new Object[capacity];
    }

    private T[] fastRemove(int index) {
        T[] newElements = initialize(elements.length);
        for (int i = 0, j = 0; i < size; i++)
            if (i != index)
                newElements[j++] = elements[i];

        return newElements;
    }

    private T[] removeLast() {
        T[] newElements = initialize(elements.length);
        for (int i = 0; i < size - 1; i++)
            newElements[i] = elements[i];

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

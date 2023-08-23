package com.collections;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] elements;
    private int size;

    public MyArrayList() {
        elements = initialize(2);
    }

    public MyArrayList(int capacity) {
        elements = initialize(capacity);
    }

    public void add(T element) {
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

    public T get(int index) {
        checkIndex(index);
        return elements[index];
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

    public T[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}

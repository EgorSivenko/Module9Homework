package com.collections;

public class MyLinkedList<T> {
    private class Node {
        private final T value;
        private Node next;
        private Node previous;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void add(T value) {
        Node node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            node.previous = last;
            last = node;
        }
        size++;
    }

    public T remove(int index) {
        Node node = getNode(index);
        T value = node.value;

        if (index == 0) {
            removeFirst();
        }
        else if (index == size - 1) {
            removeLast();
        }
        else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }

        size--;
        return value;
    }

    private void removeFirst() {
        Node next = first.next;
        first.next = null;
        next.previous = null;
        first = next;
    }

    private void removeLast() {
        Node previous = last.previous;
        last.previous = null;
        previous.next = null;
        last = previous;
    }

    public T get(int index) {
        Node node = getNode(index);
        return node.value;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void print() {
        Node node = first;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("\b");
    }

    public void printBackwards() {
        Node node = last;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.previous;
        }
        System.out.println("\b");
    }
}

package com.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> {
    private class Node {
        private final K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void put(K key, V value) {
        Node node = new Node(key, value);

        if (isEmpty()) {
            first = last = node;
        }
        else if (contains(key)) {
            getNode(key).value = node.value;
            return;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public V remove(K key) {
        Node node = getNode(key);
        V value = node.value;

        if (size == 1) {
            clear();
            return value;
        }
        else if (node == first) {
            removeFirst();
        }
        else if (node == last) {
            removeLast();
        }
        else {
            Node previousNode = getPreviousNode(node);
            previousNode.next = node.next;
            node.next = null;
        }

        size--;
        return value;
    }

    private void removeFirst() {
        Node next = first.next;
        first.next = null;
        first = next;
    }

    private void removeLast() {
        Node previous = getPreviousNode(last);
        previous.next = null;
        last = previous;
    }

    public V get(K key) {
        Node node = getNode(key);
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

    public boolean contains(K key) {
        Node node = first;
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private Node getNode(K key) {
        Node node = first;
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        throw new NoSuchElementException();
    }

    private Node getPreviousNode(Node node) {
        Node prevNode = first;
        while (prevNode.next != node) {
            prevNode = prevNode.next;
        }
        return prevNode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node node = first;

        while (node != null) {
            builder.append(node.key).append("=").append(node.value).append(",");
            node = node.next;
        }

        String[] lines = builder.toString().split(",");
        return Arrays.toString(lines);
    }
}

package com.test;

import com.collections.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------");

        MyArrayList<Integer> list = new MyArrayList<>(5);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);
        list.add(8);
        System.out.println(list);
        System.out.println(list.get(2));
        list.clear();
        System.out.println(list);
        System.out.println(list.isEmpty());

        System.out.println("----------");

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.print();
        System.out.println(linkedList.remove(1));
        linkedList.print();
        linkedList.printBackwards();
        System.out.println(linkedList.get(2));
        linkedList.clear();
        System.out.println(linkedList.isEmpty());

        System.out.println("----------");

        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        queue.add(8);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        queue.clear();
        System.out.println(queue);
        System.out.println(queue.isEmpty());

        System.out.println("----------");

        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.push(8);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.remove(1));
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);
        System.out.println(stack.isEmpty());

        System.out.println("----------");

        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "hello");
        hashMap.put(2, "bye-bye");
        hashMap.put(1, "hi");
        hashMap.put(3, "thanks");
        hashMap.put(4, "welcome");
        System.out.println(hashMap.size());
        System.out.println(hashMap);
        System.out.println(hashMap.remove(4));
        System.out.println(hashMap.size());
        System.out.println(hashMap);
        System.out.println(hashMap.remove(2));
        System.out.println(hashMap.size());
        System.out.println(hashMap);
        System.out.println(hashMap.contains(2));
        hashMap.clear();
        System.out.println(hashMap);
        System.out.println(hashMap.isEmpty());

        System.out.println("----------");
    }
}

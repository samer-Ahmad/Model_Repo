package com.samer.regestration.model.utils;

import java.util.LinkedList;

public class JeaQueue<T> {
    private int maxSize;
    private LinkedList<T> items;

    public JeaQueue(int maxSize) {
        this.items = new LinkedList<T>();
        this.maxSize = maxSize;
    }

    public void enQueue(T item) {
        if (isFull()) {
            throw new RuntimeException("you connot enQueue any Items , the Queue is Full");
        }
        this.items.addLast(item);
    }

    public T deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("you connot deQueue items , the Queue is Empty");
        }
        T item = this.items.getFirst();
        this.items.removeFirst();
        return item;
    }

    public boolean isFull() {
        return this.items.size() >= maxSize;
    }

    public boolean isEmpty() {
        return this.items.size() == 0;
    }

    @Override
    public String toString() {
        return this.items.toString();
    }
}

package com.learn.datastructure;

public class QueueArray {
    int front, rear, size;
    int capacity;
    int array[];

    public QueueArray(int capacity) {
        this.capacity = capacity;
        front = size = 0;
        rear = capacity - 1;
        array = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enqueue(int val) {
        if (isFull())
            return false;
        rear = (rear + 1) % capacity;
        array[rear] = val;
        size++;
        return true;
    }

    public int dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        int val = array[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return val;
    }

    public int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return array[front];
    }

    public int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return array[rear];
    }
}

class QueueArrayMain {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() +
                " dequeued from queue\n");

        System.out.println("Front item is " +
                queue.front());

        System.out.println("Rear item is " +
                queue.rear());
    }
}


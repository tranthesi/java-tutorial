package com.learn.review.datastructure;

public class QueueArray {
    int[] arr;
    int front, rear;
    int capacity;
    int size;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
        front = 0;
        rear = capacity - 1;
    }

    public void enqueue(int data) throws Exception {
        if(size == capacity)
            throw new Exception();
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size ++;
    }

    public int dequeue() throws Exception {
        if (size == 0)
            throw new Exception();
        int data = arr[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public int front() throws Exception {
        if (size == 0)
            throw new Exception();
        return arr[front];
    }

    public int rear() throws Exception {
        if (size == 0)
            throw new Exception();
        return arr[rear];
    }

    public void print() {
        for(int i=0; i<size; i++) {
            System.out.print(arr[(front+i)%capacity] + " ");
        }
        System.out.println();
    }
}

class QueueArrayMain {

    public static void main(String[] args) throws Exception {
        QueueArray queue = new QueueArray(20);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.front());
        System.out.println(queue.rear());
        queue.print();
    }

}

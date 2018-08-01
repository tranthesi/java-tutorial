package com.learn.datastructure.queue;

import java.util.Stack;

public class TwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println(myQueue.peek());
    }
}


class MyQueue <T> {
    Stack<T> stack1 = new Stack();
    Stack<T> stack2 = new Stack();

    public void enqueue(T ele) {
        stack1.push(ele);
    }

    public T dequeue() {
        arrange();
        if(stack2.isEmpty())
            return null;
        return stack2.pop();
    }

    public T peek() {
        arrange();
        if(stack2.isEmpty())
            return null;
        return stack2.peek();
    }

    void arrange() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
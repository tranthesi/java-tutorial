package com.learn.review.datastructure;

public class StackArray {
    int[] arr;
    int capacity;
    int top;

    public StackArray(int capacity) {
        this.capacity = capacity;
        top = -1;
        arr = new int[capacity];
    }

    public void push(int data) throws Exception {
        if(top == capacity -1)
            throw new Exception();
        arr[++top] = data;
    }

    public int pop() throws Exception {
        if(top < 0)
            throw  new Exception();
        return  arr[top--];
    }

    public int top() throws Exception {
        if(top < 0)
            throw  new Exception();
        return  arr[top];
    }
}

class MainStackArray
{
    public static void main(String args[]) throws Exception {
        StackArray s = new StackArray(20);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }
}
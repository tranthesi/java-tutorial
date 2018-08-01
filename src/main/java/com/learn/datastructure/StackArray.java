package com.learn.datastructure;

public class StackArray {
    static final int MAX_SIZE = 1000;
    int top;
    int[] arr = new int[MAX_SIZE];

    public StackArray() {
        top = -1;
    }

    boolean isEmpty() {
        return top < 0;
    }

    public boolean push(int x) {
        if(top >= MAX_SIZE -1) {
            return false;
        }
        arr[++top] = x;
        return true;
    }

    public int pop() {
        if(top < 0) {
            return Integer.MIN_VALUE;
        }
        return arr[top--];
    }

    public int top() {
        if(top < 0) {
            return Integer.MIN_VALUE;
        }
        return arr[top];
    }
}

class MainStackArray
{
    public static void main(String args[])
    {
        StackArray s = new StackArray();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }
}

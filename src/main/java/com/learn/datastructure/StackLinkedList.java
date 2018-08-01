package com.learn.datastructure;

class StackNode {
    int data;
    StackNode next;

    StackNode(int d) {
        data = d;
    }
}

public class StackLinkedList {
    StackNode root;

    public boolean isEmpty() {
        return root != null;
    }

    public void push(int data) {
        StackNode node = new StackNode(data);
        node.next = root;
        root = node;
    }

    public int pop() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int data = root.data;
        root = root.next;
        return data;
    }

    public int top() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return root.data;
    }
}

class StackLinkedListMain {
    public static void main(String args[])
    {
        StackLinkedList s = new StackLinkedList();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop() + " Popped from stack");
        System.out.println(s.top() + " Top from stack");
    }
}

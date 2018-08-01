package com.learn.datastructure;

public class CircularSinglyLinked {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node last;

    public CircularSinglyLinked() {
        last = null;
    }

    public void addToEmpty(int data) {
        Node newNode = new Node(data);
        newNode.next = newNode;
        last = newNode;
    }

    public void insertFirst(int data) {
        if(last == null) {
            addToEmpty(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
    }

    public void insertLast(int data) {
        if(last == null) {
            addToEmpty(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
    }

}

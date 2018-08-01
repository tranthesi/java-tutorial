package com.learn.review.datastructure;

public class LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;

    public LinkedList() {
        head = null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node p = head;
        while(p.next!= null) {
            p = p.next;
        }
        p.next = newNode;
    }

    public void removeFirst() {
        if (head == null)
            return;
        head = head.next;
    }

    public void removeLast() {
        if (head == null)
            return;
        if (head.next == null)
            head = null;

        Node p = head;
        Node q = null;
        while(p.next!= null) {
            q = p;
            p = p.next;
        }
        q.next = null;
    }

    public int getFirst() throws Exception {
        if (head == null)
            throw new Exception();
        return head.data;
    }

    public int getLast() throws Exception {
        if (head == null)
            throw new Exception();
        Node p = head;
        while(p.next!= null) {
            p = p.next;
        }
        return  p.data;
    }

    public void print() {
        Node p = head;
        while(p!= null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}

class LinkedListTest {
    public static void main(String[] args) throws Exception {
        LinkedList lst = new LinkedList();
        lst.insertFirst(2);
        lst.insertFirst(1);
        lst.insertLast(3);
        lst.insertLast(4);
        lst.insertLast(5);
        lst.removeFirst();
        lst.removeLast();
        System.out.println(lst.getFirst());
        System.out.println(lst.getLast());
        lst.print();
    }
}

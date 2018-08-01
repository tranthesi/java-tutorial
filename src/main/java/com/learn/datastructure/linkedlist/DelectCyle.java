package com.learn.datastructure.linkedlist;

public class DelectCyle {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        node1.next = node2;
        node2.next = node2;
        System.out.println(hasCycle(node1));
    }

    static boolean hasCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
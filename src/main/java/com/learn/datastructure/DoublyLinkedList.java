package com.learn.datastructure;

public class DoublyLinkedList {

    static class Node {
        int data;
        Node next, prev;

        public Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public void insertHead(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertAfter(Node node, int data) {
        Node newNode = new Node(data);
        Node next = node.next;

        node.next = newNode;
        newNode.prev = node;

        if (next != null) {
            newNode.next = next;
            next.prev = newNode;
        }
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        newNode.prev = p;
    }

    public void insertBefore(Node node, int data) {
        Node newNode = new Node(data);
        Node pre = newNode.prev;

        newNode.next = node;
        node.prev = newNode;

        if (pre == null) {
            head = newNode;
        } else {
            pre.next = newNode;
            newNode.prev = pre;
        }
    }

    public void deleteNode(Node del) {
        Node pre = del.prev;
        Node next = del.next;

        if(pre != null) {
            pre.next = del.next;
        }

        if(next != null) {
            next.prev = del.prev;
        }

        if(pre == null)
            head = next;
    }

    public void reverse() {
        Node tmp = null;
        Node current = head;

        while (current != null) {
            tmp = current.prev;
            current.prev = current.next;
            current.next = tmp;

            current = current.prev;
        }

        if (tmp != null) {
            head = tmp.prev;
        }
    }

    public void printlist(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }
}

class DoublyLinkedListMain {
    public static void main(String[] args)
    {
        /* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        dll.insertLast(6);

        // Insert 7 at the beginning. So linked list becomes 7->6->NULL
        dll.insertHead(7);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
        dll.insertHead(1);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
        dll.insertLast(4);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
        dll.insertAfter(dll.head.next, 8);

        System.out.println("Created DLL is: ");
        dll.printlist(dll.head);

        dll.deleteNode(dll.head.next);
        dll.printlist(dll.head);

        dll.reverse();
        dll.printlist(dll.head);
    }
}

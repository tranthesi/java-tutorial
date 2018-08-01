package com.learn.review.datastructure;

public class Btree {

    class Node {
        int[] keys;
        Node[] childs;
        int t; //degree
        int n; //current number of key

        public Node(int degree) {
            t = degree;
            n = 0;
            keys = new int[2*t-1];
            childs = new Node[2*t];
        }

        public void traverse() {
            int i = 0;
            for(i =0; i<n; i++) {
                if(childs[i] != null)
                    childs[i].traverse();
                System.out.print(keys[i] + " ");
            }
            if(childs[i] != null)
                childs[i].traverse();
        }

        public Node search(int k) {
            int i = 0;
            while (i < n && k > keys[i])
                i++;

            if(keys[i] == k)
                return this;

            if(childs[i] == null)
                return null;
            return childs[i].search(k);
        }
    }

    Node root;
    int t;

    public Btree(int t) {
        this.t = t;
        root = null;
    }

    public void insert(int k) {
        if(root == null)
        {
            root = new Node(t);
            root.keys[0] = k;
            root.n = 1;
        } else {
            //
        }
    }


}

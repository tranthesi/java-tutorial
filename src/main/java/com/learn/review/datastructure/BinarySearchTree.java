package com.learn.review.datastructure;

public class BinarySearchTree {

    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertNode(int key) {
        root = insertNodeRec(root, key);
    }

    Node insertNodeRec(Node node, int key) {
        if(node == null) {
            Node newNode = new Node(key);
            return newNode;
        }

        if(key < node.key) {
            node.left = insertNodeRec(node.left, key);
        } else {
            node.right = insertNodeRec(node.right, key);
        }
        return node;
    }

    public void removeNode(int key) {
        root = removeNodeRec(root, key);
    }

    Node removeNodeRec(Node node, int key) {
        if(node == null)
            return null;
        if(key < node.key) {
            node.left = removeNodeRec(node.left, key);
        } else if(key > node.key) {
            node.right = removeNodeRec(node.right, key);
        } else {
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            } else {
                Node min = findMin(node.right);
                node.key = min.key;
                removeNodeRec(node.right, min.key);
            }
        }
        return node;
    }

    Node findMin(Node node) {
        while(node.left != null)
            node = node.left;
        return node;
    }

    public void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node node) {
        if(node == null)
            return;
        inorderRec(node.left);
        System.out.print(node.key + " ");
        inorderRec(node.right);
    }
}


class BinarySearchTreeMain {
    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(70);
        tree.insertNode(60);
        tree.insertNode(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.removeNode(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.removeNode(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.removeNode(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}
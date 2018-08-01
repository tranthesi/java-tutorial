package com.learn.datastructure;

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

    public void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }

        if(key < root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node node) {
        if(node == null)
            return;
        inorderRec(node.left);
        System.out.println(node.key);
        inorderRec(node.right);
    }

    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node node, int key) {
        if(node == null)
            return node;
        if(key < node.key) {
            node.left = deleteRec(node.left, key);
        } else if(key > node.key) {
            node.right = deleteRec(node.right, key);
        } else {
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            }
            node.key = minValue(node.right);
            node.right = deleteRec(node.right, node.key);
        }
        return node;
    }

    int minValue(Node root) {
        int minV = root.key;
        while (root.left != null) {
            root = root.left;
            minV = root.key;
        }
        return minV;
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
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}

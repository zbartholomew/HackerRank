package com.zbartholomew.java;


// AVL tree - self-balancing binary search tree
public class SelfBalancingTree {

    static class Node {
        int val;
        int ht;
        Node left;
        Node right;
    }

    static Node insert(Node root, int val) {

        // Create node with given value if no tree exists
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = setHeight(root);
            return root;
        }

        if (val <= root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        int balanceFactor = height(root.left) - height(root.right);

        if (balanceFactor > 1) {
            if (height(root.left.left) >= height(root.left.right)) {
                root = rightRotation(root);
            } else {
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        } else if (balanceFactor < -1) {
            if (height(root.right.right) >= height(root.right.left)) {
                root = leftRotation(root);
            } else {
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }
        } else {
            root.ht = setHeight(root);
        }
        return root;
    }

    private static Node rightRotation(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.ht = setHeight(root);
        newRoot.ht = setHeight(newRoot);
        return newRoot;
    }

    private static Node leftRotation(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.ht = setHeight(root);
        newRoot.ht = setHeight(newRoot);
        return newRoot;
    }

    private static int height(Node root) {
        if (root == null)
            return -1;
        else
            return root.ht;
    }

    private static int setHeight(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 3;
        root.left = new Node();
        root.left.val = 2;
        root.right = new Node();
        root.right.val = 4;
        root.right.right = new Node();
        root.right.right.val = 5;

        Node sortedAVLTree = insert(root, 6);
        System.out.println(sortedAVLTree);
    }
}

package com.zbartholomew.java;

/**
 * Created by Zach on 7/27/2017.
 */
public class BSTLowestCommenAncestor {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node lca(Node root, int v1, int v2) {

        while (root != null) {
            if (root.data > v1 && root.data > v2) {
                root = root.left;
            } else if (root.data < v1 && root.data < v2) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Node root = new Node();
        root.data = 4;

        root.left = new Node();
        root.left.left = new Node();
        root.left.right = new Node();
        root.right = new Node();
        root.right.left = new Node();
        root.right.left.left = new Node();
        root.right.left.right = new Node();
        root.right.right = new Node();

        root.left.data = 2;
        root.left.left.data = 1;
        root.left.right.data = 3;
        root.right.data = 10;
        root.right.left.data = 7;
        root.right.left.left.data = 5;
        root.right.left.right.data = 8;
        root.right.right.data = 12;

        Node search = lca(root, 1, 7);
        System.out.println(search.data);

        Node search1 = lca(root, 1, 3);
        System.out.println(search1.data);

        Node search2 = lca(root, 5, 8);
        System.out.println(search2.data);

        Node search3 = lca(root, 5, 11);
        System.out.println(search3.data);
    }
}

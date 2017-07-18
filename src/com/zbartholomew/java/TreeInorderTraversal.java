package com.zbartholomew.java;

/**
 * Created by Zach on 7/16/2017.
 */
public class TreeInorderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }

    void inOrder(Node root) {

        if (root == null) {
            return;
        }

        // we know nodes to the left are less than nodes to the right
        inOrder(root.left);
        // if root.left is not null we will print that otherwise print root.right
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}

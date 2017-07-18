package com.zbartholomew.java;

/**
 * Created by Zach on 7/15/2017.
 */
public class TreePreorderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }

    void preOrder(Node root) {

        Node previous;

        if (root == null) {
            return;
        }

        Node current = root;

        while (current != null) {
            if (current.left == null) {
                // print out root
                System.out.print(current.data + " ");
                // go right since left is null
                current = current.right;
            } else {
                // prioritize going left rather than right
                previous = current.left;

                while (previous.right != null && previous.right != current)
                    previous = previous.right;

                if (previous.right == null) {
                    previous.right = current;
                    System.out.println(current.data);
                    current = current.left;
                } else {
                    previous.right = null;
                    current = current.right;
                }

            }
        }
    }
}

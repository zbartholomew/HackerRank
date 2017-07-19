package com.zbartholomew.java;

/**
 * Created by Zach on 7/17/2017.
 */
public class TreeTopView {

    class Node {
        int data;
        Node left;
        Node right;
    }

    void topView(Node root) {
        if (root != null) {
            topView(root.left, true);

            System.out.print(root.data + " ");

            topView(root.right, false);
        }
    }

    void topView(Node node, boolean side) {
        if (node != null) {
            if (side) {
                topView(node.left, side);
                System.out.print(node.data + " ");
            } else {
                System.out.print(node.data + " ");
                topView(node.right, side);
            }
        }
    }
}
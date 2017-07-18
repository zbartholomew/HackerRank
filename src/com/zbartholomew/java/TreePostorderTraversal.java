package com.zbartholomew.java;

import java.util.ArrayList;

/**
 * Created by Zach on 7/15/2017.
 */
public class TreePostorderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }


    void postOrder(Node root) {

        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }
}
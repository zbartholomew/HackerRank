package com.zbartholomew.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 7/28/2017.
 */
public class IsThisBST {

    static List<Integer> inOrderBSTList = new ArrayList<>();

    static class Node {
        int data;
        Node left;
        Node right;
    }

    static void inOrder(Node root) {

        if (root == null) {
            return;
        }

        // we know nodes to the left are less than nodes to the right
        inOrder(root.left);
        // if root.left is not null we will print that otherwise print root.right
        inOrderBSTList.add(root.data);
        inOrder(root.right);
    }

    static boolean checkBST(Node root) {

        // non-recursive solution
        inOrder(root);
        for (int i = 0; i < inOrderBSTList.size()-1; i++) {
            if (inOrderBSTList.get(i) > inOrderBSTList.get(i+1)) {
                return false;
            }
        }

        return true;

        // recursion solution
//        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBST(Node n, int min, int max) {



        /*  Recursion solution
        // quit if we get to a null Node and return true since all negative checks failed
        if (n == null) {
            return true;
        }

        // check if not a BST
        if (n.data <= min || n.data >= max) {
            return false;
        } else if ( (!checkBST(n.left, min, n.data)) ||
                (!checkBST(n.right, n.data, max))) {
            return false;
        }

        // this node level is a BST return and call recursively to check other levels
        return true;
        */

        // placeholder not using recursion
        return false;
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

        System.out.println(checkBST(root));
    }
}

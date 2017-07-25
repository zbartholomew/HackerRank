package com.zbartholomew.java;

/**
 * Created by Zach on 7/24/2017.
 */
public class BSTInsertion {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node Insert(Node root,int value) {

//        Node newNode = new Node();
//        newNode.data = value;
//
//        if (root == null) {
//            return newNode;
//        }
//
//        Node iterator = root;
//        while (iterator != null) {
//            if (value < iterator.data) {
//                if (iterator.left == null) {
//                    iterator.left = newNode;
//                    break;
//                }
//                iterator = iterator.left;
//            } else {
//                if (iterator.right == null) {
//                    iterator.right = newNode;
//                    break;
//                }
//                iterator = iterator.right;
//            }
//        }
//        return root;

        if(root==null)
        {
            Node node=new Node();
            node.data=value;
            node.left=null;
            node.right=null;
            root=node;
        }
        else if(root.data>value)
            root.left=Insert(root.left,value);
        else if(root.data<value)
            root.right=Insert(root.right,value);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.data = 14;

        Node rootLeft = new Node();
        rootLeft.data = 5;

        Node rootRight = new Node();
        rootRight.data = 20;


        root.left = rootLeft;
        root.right = rootRight;

        Insert(root, 2);
    }

}

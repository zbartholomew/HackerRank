package com.zbartholomew.java;

/**
 * Created by Zach on 7/27/2017.
 */
public class LinkedListInsertNodeHead {

    static class Node {
        int data;
        Node next;
    }

    static Node Insert(Node head,int x) {

        Node node = new Node();
        node.next = head;
        node.data = x;
        return node;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.data = 2;
        node1.next = new Node();
        node1.next.data = 3;

        Insert(node1, 4);
    }
}

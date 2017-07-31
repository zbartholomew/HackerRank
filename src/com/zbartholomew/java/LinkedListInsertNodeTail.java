package com.zbartholomew.java;

/**
 * Created by Zach on 7/26/2017.
 */
public class LinkedListInsertNodeTail {

    static class Node {
        int data;
        Node next;
    }

    static Node Insert(Node head,int data) {

        if (head == null) {
            Node node = new Node();
            node.data = data;
            head = node;
        } else {
            head.next = Insert(head.next, data);
        }

        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.data = 2;
        node1.next = new Node();
        node1.next.data = 3;

        Insert(node1, 4);
    }
}

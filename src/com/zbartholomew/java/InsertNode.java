package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list

public class InsertNode {

    /*
     Insert Node at a given position in a linked list
     head can be NULL
     First element in the linked list is at position 0
     Node is defined as */
    static class Node {
        int data;
        Node next;
    }

    public static Node InsertNth(Node head, int data, int position) {

        Node nodeToInsert = new Node();
        nodeToInsert.data = data;

        if (head == null) {
            return nodeToInsert;
        }

        if (position == 0) {
            nodeToInsert.next = head;
            return nodeToInsert;
        }

        Node curr = head;

        int currPosition = 0;

        while (currPosition < position - 1 && head.next != null) {
            head = head.next;
            currPosition++;
        }

        Node nodeAtPosition = head.next;
        head.next = nodeToInsert;
        head = head.next;
        head.next = nodeAtPosition;

        return curr;
    }

}

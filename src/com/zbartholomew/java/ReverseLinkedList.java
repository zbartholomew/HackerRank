package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/reverse-a-linked-list?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class ReverseLinkedList {

    /*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element
  Node is defined as */

    static class Node {
        int data;
        Node next;
    }

    Node Reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        // recursion
//        Node remaining = Reverse(head.next);
//
//        head.next.next = head;
//        head.next = null;
//
//        return remaining;

        // iterative
        Node preNode = null;
        Node currNode = head;
        Node nextNode = null;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        head = preNode;

        return head;
    }
}

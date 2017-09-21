package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class PrintReverse {

    /*
  Print elements of a linked list in reverse order
  head pointer input could be NULL as well for empty list
  Node is defined as */
    static class Node {
        int data;
        Node next;
    }

    // This is a "method-only" submission.
    // You only need to complete this method.

    void ReversePrint(Node head) {
        if (head == null) {
            return;
        }

        ReversePrint(head.next);
        System.out.println(head.data);
    }
}

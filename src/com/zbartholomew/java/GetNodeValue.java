package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class GetNodeValue {

    /*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as  */
    static class Node {
        int data;
        Node next;
    }

    int GetNode(Node head, int n) {
        int index = 0;
        Node curr = head;
        Node result = head;

        while (curr != null) {
            curr = curr.next;
            if (index++ > n) {
                result = result.next;
            }
        }
        return result.data;
    }

}

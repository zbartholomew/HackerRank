package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class DeleteNode {
    /*
  Delete Node at a given position in a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as */
    static class Node {
        int data;
        Node next;
    }

    Node Delete(Node head, int position) {

        // recursion
//        if (position == 0) {
//            return head.next;
//        }
//        head.next = Delete(head.next, position - 1);
//        return head;

        // iterative
        if (position == 0) {
            return head.next;
        }
        if (head == null) {
            return head;
        }

        Node curr = head;
        int count = 0;
        while (count++ < (position - 1)) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
    }
}


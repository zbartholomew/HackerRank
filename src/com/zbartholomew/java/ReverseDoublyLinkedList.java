package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class ReverseDoublyLinkedList {

    /*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as */
  static class Node {
     int data;
     Node next;
     Node prev;
  }

    // Recursive
    Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            head.prev = null;
            return head;
        }

        Node newHead = reverse(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;

        return newHead;
    }

    // Iterative
    Node reverse(Node head) {
        Node temp = head;
        Node newHead = head;

        while (temp != null) {
            Node prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            newHead = temp;
            temp = temp.prev;
        }
        return newHead;
    }
}

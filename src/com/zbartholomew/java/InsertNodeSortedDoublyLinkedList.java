package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class InsertNodeSortedDoublyLinkedList {

    /*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as  */
    static class Node {
        int data;
        Node next;
        Node prev;
    }


    Node SortedInsert(Node head, int data) {
        if (head == null) {
            Node newNode = new Node();
            newNode.data = data;
            return newNode;
        }

        if (head.data <= data) {
            head.next = SortedInsert(head.next, data);
            head.next.prev = head;
        } else if (head.data > data) {
            Node newNode = new Node();
            newNode.data = data;

            newNode.next = head;
            newNode.prev = head.prev;

            head.prev = newNode;
            head = newNode;
        }

        return head;
    }
}

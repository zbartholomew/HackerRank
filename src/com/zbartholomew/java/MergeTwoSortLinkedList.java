package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class MergeTwoSortLinkedList {

    /*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as  */
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }


    static Node mergeLists(Node headA, Node headB) {

        // recursive
//        if (headA == null)
//            return headB;
//        else if (headB == null)
//            return headA;
//        else if (headA.data <= headB.data) {
//            headA.next = mergeLists(headA.next, headB);
//            return headA;
//        } else {
//            headB.next = mergeLists(headA, headB.next);
//            return headB;
//        }

        // iterative
        if (headA == null) {
            return headB;
        } else if (headB == null) {
            return headA;
        }

        /* Find new head pointer */
        Node head;
        if (headA.data < headB.data) {
            head = headA;
            headA = headA.next;
        } else {
            head = headB;
            headB = headB.next;
        }

        /* Build rest of list */
        Node n = head;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                n.next = headA;
                headA = headA.next;
            } else {
                n.next = headB;
                headB = headB.next;
            }
            n = n.next;
        }

        /* Attach the remaining elements */
        if (headA == null) {
            n.next = headB;
        } else {
            n.next = headA;
        }

        return head;
    }


    public static void main(String[] args) {
        Node headA = new Node(1);
        headA.next = new Node(3);
        headA.next.next = new Node(5);
        headA.next.next.next = new Node(6);

        Node headB = new Node(2);
        headB.next = new Node(4);
        headB.next.next = new Node(7);

        Node temp = mergeLists(headA, headB);
        System.out.println(temp.toString());
    }
}

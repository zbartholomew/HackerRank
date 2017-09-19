package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/compare-two-linked-lists?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class CompareTwoLinkedList {
    /*
      Compare two linked lists A and B
      Return 1 if they are identical and 0 if they are not.
      Node is defined as  */
    class Node {
        int data;
        Node next;
    }

    int CompareLists(Node headA, Node headB) {

        Node currA = headA;
        Node currB = headB;

        while (currA != null && currB != null) {
            if (currA.data != currB.data) {
                return 0;
            }
            currA = currA.next;
            currB = currB.next;
        }

        if (currA != null || currB != null) {
            return 0;
        } else {
            return 1;
        }
    }

}

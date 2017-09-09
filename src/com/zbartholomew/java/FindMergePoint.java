package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class FindMergePoint {
    /*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
  */

    static class Node {
        int data;
        Node next;
    }

    int findMergeNode(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;

        //Do till the two nodes are the same
        while(currentA != currentB){
            //If you reached the end of one list start at the beginning of the other one
            //currentA
            if(currentA.next == null){
                currentA = headB;
            }else{
                currentA = currentA.next;
            }
            //currentB
            if(currentB.next == null){
                currentB = headA;
            }else{
                currentB = currentB.next;
            }
        }
        return currentB.data;
    }
}

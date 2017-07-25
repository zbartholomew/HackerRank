package com.zbartholomew.java;

/**
 * Created by Zach on 7/24/2017.
 */
public class PrintElementsLinkedList {

    class Node {
        int data;
        Node next;
    }

    void print(Node head) {

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

//        if (head != null) {
//            System.out.println(head.data);
//            print(head.next);
//        }
    }
}

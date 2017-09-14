package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class DeleteDupSortLinkedList {
    //Node is defined as
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }


    static Node RemoveDuplicates(Node head) {

        // iterative method
        if(head==null || head.next==null) return head;
        Node currNode = head;
        while (currNode.next != null) {
            if (currNode.data != currNode.next.data) {
                currNode = currNode.next;
            } else {
                currNode.next = currNode.next.next;
            }
        }

        return head;

        // recursive
//        if (head == null) return null;
//        Node nextNode = head.next;
//        while (nextNode != null && head.data == nextNode.data) {
//            nextNode = nextNode.next;
//        }
//        head.next = RemoveDuplicates(nextNode);
//        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(4);

        Node test = RemoveDuplicates(head);
        System.out.println(test.toString());
    }
}

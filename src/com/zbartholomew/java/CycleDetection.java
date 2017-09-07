package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class CycleDetection {

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    static boolean hasCycle(Node head) {

//        if (head == null || head.next == null) {
//            return false;
//        }
//
//        List<Node> visited = new ArrayList<>();
//        Node node = head;
//        while (node != null) {
//            visited.add(node);
//            node = node.next;
//            if (visited.contains(node)) {
//                return true;
//            }
//        }
//
//        return false;

        if (head == null){
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1, null);

        Node head2 = new Node(1);
        Node head1 = new Node(1, head2);
        Node head3 = new Node(1, head2);
        head2.next = head3;

        System.out.println(hasCycle(head));
        System.out.println(hasCycle(head1));
    }
}

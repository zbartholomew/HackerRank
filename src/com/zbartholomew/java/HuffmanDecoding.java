package com.zbartholomew.java;

/**
 * Created by Zach on 7/27/2017.
 */
public class HuffmanDecoding {

    static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    static void decode(String s, Node root) {

        Node last = root;

        for (int i = 0; i < s.length(); i++) {

            last = s.charAt(i) == '1' ? last.right : last.left;
            if (last.left == null && last.right == null) {
                System.out.print(last.data);
                last = root;
            }
        }

//        Node last = root;
//
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//
//            switch (s.charAt(i)) {
//                case '1':
//                    if (last.right != null) {
//                        last = last.right;
//                        count++;
//                    } else {
//                        System.out.print(last.data);
//                        last = root;
//                        i -= count;
//                        count = 0;
//                    }
//                    break;
//                case '0':
//                    if (last.left != null) {
//                        last = last.left;
//                        count++;
//                    } else {
//                        System.out.print(last.data);
//                        last = root;
//                        i -= count;
//                        count = 0;
//                    }
//                    break;
//                default:
//                    throw new IllegalArgumentException("string error");
//            }
//        }
    }

    public static void main(String[] args) {
        Node node = new Node();
        String s = "1001011";

        node.right = new Node();
        node.left = new Node();
        node.right.data = 'A';
        node.left.data = '\0';

        node.left.left = new Node();
        node.left.right = new Node();
        node.left.left.data = 'B';
        node.left.right.data = 'C';

        decode(s, node);
    }

}

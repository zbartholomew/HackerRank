package com.zbartholomew.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodes {

    static class Node {
        int data;
        int depth;
        Node left, right;

        Node(int data, int depth) {
            this.data = data;
            this.depth = depth;
        }
    }

    public static void swap_nodes(Node root, int K) {
        if (root != null) {
            if (root.depth % K == 0) {
                Node tmp = root.left;
                root.left = root.right;
                root.right = tmp;
            }
            swap_nodes(root.left, K);
            swap_nodes(root.right, K);
        }
    }

    public static void inorder_print(Node root) {
        if (root != null) {
            inorder_print(root.left);
            System.out.print(root.data + " ");
            inorder_print(root.right);
        }
    }

    public static void print_nodes(Node root, int K) {
        swap_nodes(root, K);
        inorder_print(root);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Node root = new Node(1, 1);
        Node cur = root;

        Queue<Node> nodes = new LinkedList<>();

        nodes.offer(cur);

        while (N-- > 0) {
            cur = nodes.poll();
            int leftData = in.nextInt();
            int rightData = in.nextInt();

            cur.left = (leftData == -1) ? null : new Node(leftData, cur.depth + 1);
            cur.right = (rightData == -1) ? null : new Node(rightData, cur.depth + 1);

            if (cur.left != null && cur.left.data != -1) {
                nodes.offer(cur.left);
            }
            if (cur.right != null && cur.right.data != -1) {
                nodes.offer(cur.right);
            }
        }

        int T = in.nextInt();
        while (T-- > 0) {
            int K = in.nextInt();
            print_nodes(root, K);
        }
    }
}

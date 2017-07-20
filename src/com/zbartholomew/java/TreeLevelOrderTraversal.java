package com.zbartholomew.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Zach on 7/19/2017.
 */
public class TreeLevelOrderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }

    void levelOrder(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            Node t = q.poll();
            System.out.print(t.data + " ");
            if (t.left != null) q.offer(t.left);
            if (t.right != null) q.offer(t.right);
        }
    }
}

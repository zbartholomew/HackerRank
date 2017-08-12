package com.zbartholomew.java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// Resource - http://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

public class QueriesWithFixedLength {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] queryArray = new int[n];

        for (int i = 0; i < n; i++) {
            queryArray[i] = in.nextInt();
        }


        for (int i = 0; i < q; i++) {
            int d = in.nextInt();
            int ans = Integer.MAX_VALUE;
            // queue maintains the index and not the elements.
            Deque<Integer> dq = new LinkedList<>();

            //  Make queue in descending order
            for (int j = 0; j < d; j++) {
                while (!dq.isEmpty() && queryArray[dq.getLast()] < queryArray[j]) {
                    dq.removeLast();
                }
                dq.addLast(j);
            }

            /*
            - Find and set minimum from last minimum and first element of queue.
            - Find if the last elements of the queue is still in the window.
                - If not, remove last element.
            - Add elements if they are in descending order and ignore the values in between.
             */
            for (int j = d; j < n; j++) {
                ans = Math.min(queryArray[dq.getFirst()], ans);

                while (!dq.isEmpty() && dq.getFirst() <= j - d) {
                    dq.removeFirst();
                }

                while (!dq.isEmpty() && queryArray[dq.getLast()] < queryArray[j]) {
                    dq.removeLast();
                }
                dq.addLast(j);
            }

            // The first element of the queue will be the maximum of its window and minimum of all the elements.
            System.out.println(Math.min(ans, queryArray[dq.getFirst()]));
        }
    }

}


package com.zbartholomew.java;

import java.util.*;

public class QHEAP1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // number of queries
        int n = in.nextInt();

        Queue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int q = in.nextInt();


            switch (q) {
                case 1:
                    heap.add(in.nextInt());
                    break;
                case 2:
                    heap.remove(in.nextInt());
                    break;
                case 3:
                    System.out.println(heap.peek());
                    break;
            }
        }
    }
}

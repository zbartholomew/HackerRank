package com.zbartholomew.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaxElementStack {

    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        max.addFirst(Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int type = in.nextInt();

            switch (type) {
                case 1:
                    int x = in.nextInt();
                    stack.addFirst(x);
                    if (x >= max.peekFirst()) {
                        max.addFirst(x);
                    }
                    break;

                case 2:
                    if (max.peekFirst().equals(stack.peekFirst())) {
                        max.removeFirst();
                    }
                    stack.removeFirst();
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println(max.peekFirst());
                    }
                    break;
            }
        }

        in.close();
    }
}

package com.zbartholomew.java;

import java.util.*;

public class JesseAndCookies {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Queue<Integer> a = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }
        in.close();

        int count = 0;
        while (a.peek() < k && a.size() > 1) {
            a.add((a.poll() + (a.poll() * 2)));
            count++;
        }
        if (a.peek() >= k) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}

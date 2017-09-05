package com.zbartholomew.java;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/crush

public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] array = new long[n + 1];

        for (int a0 = 0; a0 < m; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            array[a] += k;
            if ((b + 1) <= n) array[b + 1] -= k;
        }
        in.close();

        long x = 0, max = 0;
        for (int i = 0; i <= n; i++) {
            x = x + array[i];
            if (max < x) max = x;
        }

        System.out.println(max);
    }
}

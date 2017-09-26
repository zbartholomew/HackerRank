package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/equal

import java.util.Scanner;

public class Equal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            System.out.println(numOfOperationsToEqual(a));
        }
    }

    private static long numOfOperationsToEqual(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int m : arr) {
            if (min > m) {
                min = m;
            }
        }

        long sum = Long.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int cSum = 0;
            for (int a : arr) {
                int diff = a - min + i;
                cSum += (diff / 5) + ((diff % 5) / 2) + ((diff % 5) % 2);
            }
            sum = Math.min(cSum, sum);
        }
        return sum;
    }
}

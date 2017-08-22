package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/unbounded-knapsack?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int numOfTests = in.nextInt();
//
//        for (int i = 0; i < numOfTests; i++) {
//            int n = in.nextInt();
//            int k = in.nextInt();
//
//            int[] array = new int[n];
//            int[][] table = new int[k + 1][n];
//
//            for (int j = 0; j < n; j++) {
//                array[j] = in.nextInt();
//                table[0][j] = 0;
//            }
//
//            for (int x = 0; x <= k; x++) {
//                for (int y = 0; y < n; y++) {
//                    if (y == 0) {
//                        if (x >= array[y]) {
//                            table[x][y] = table[x - array[y]][y] + array[y];
//                        } else {
//                            table[x][y] = 0;
//                        }
//                    } else {
//                        if (i >= array[y]) {
//                            table[x][y] = Math.max(table[x][y - 1], table[x - array[y]][y] + array[y]);
//                        } else {
//                            table[x][y] = table[x][y - 1];
//                        }
//                    }
//                }
//            }
//            System.out.println(table[k][n - 1]);
//        }
//        in.close();
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numOfTests = in.nextInt();

        for (int i = 0; i < numOfTests; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                a[j] = in.nextInt();
            }

            System.out.println(knapsackIterative(a, n, k));
        }
    }

    static int knapsackIterative(int[] a, int n, int k) {
        int[] dp = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            int[] tmp = Arrays.copyOf(dp, k + 1);

            for (int x = 0; x <= k; x++) {
                int max = 0;

                for (int y = 0; y * a[i] <= x; y++) {
                    max = Math.max(max, y * a[i] + tmp[x - y * a[i]]);
                }

                dp[x] = max;
            }
        }

        return dp[k];
    }
}

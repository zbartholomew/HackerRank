package com.zbartholomew.java.WeekOfCode34;

import java.util.Scanner;

/**
 * Created by Zach on 7/19/2017.
 */
public class SameOccurence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        for (int a0 = 0; a0 < q; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();

            queryArray(arr, n, x, y);
        }
        in.close();
    }

    private static void queryArray(int[] arr, int n, int x, int y) {

        int total = 0;

        int countX = 0;
        int countY = 0;
        for (int a : arr) {
            if (a == x) {
                countX++;
            } else if (a == y) {
                countY++;
            }
        }

        // no common terms - quit early using polynomial expression to calculate num of subarrays
        if (countX == 0 && countY == 0) {
            Double d = (.5) * n * (n + 1);
            Integer i = d.intValue();
            System.out.println(i);
            return;
        }

        for (int i = 0; i < n; i++) {
            // j is the number of elements which should be printed
            for (int j = i; j < n; j++) {
                countX = 0;
                countY = 0;
                // print the array from i to j
                for (int k = i; k <= j; k++) {
//                    System.out.print(arr[k]);
                    if (arr[k] == x) {
                        countX++;
                    } else if (arr[k] == y) {
                        countY++;
                    }
                }
//                System.out.println(countX + " " + countY);
                if (countX == countY) {
                    total++;
                }
//                System.out.println();
            }
        }

        System.out.println(total);
    }
}

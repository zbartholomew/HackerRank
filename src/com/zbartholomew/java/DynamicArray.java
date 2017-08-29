package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/dynamic-array?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();

        int[][] a = new int[n][];
        int[] tmp;
        int lastAnswer = 0, len = 0;
//
//        for (int i = 0; i < q; i++) {
//            int queryType = in.nextInt();
//            int x = in.nextInt();
//            int y = in.nextInt();
//            int c = (x^lastAnswer) % n;
//
//            switch (queryType) {
//                case 1:
//                    if (a[c] == null)
//                        len = 1;
//                    else
//                        len = a[c].length + 1;
//                    tmp = new int[len];
//                    if(a[c] != null)
//                        System.arraycopy(a[c], 0, tmp, 0, a[c].length);
//                    tmp[tmp.length-1] = y;
//                    a[c] = tmp;
//                    break;
//                case 2:
//                    System.out.println(lastAnswer = a[c][y % a[c].length]);
//            }
//        }
//        in.close();
//    }

        ArrayList<Integer>[] list = new ArrayList[n];

        for (int i = 0; i < q; i++) {
            int queryType = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int c = (x ^ lastAnswer) % n;

            switch (queryType) {
                case 1:
                    if (list[c] == null) {
                        ArrayList<Integer> myList = new ArrayList<>();
                        myList.add(y);
                        list[c] = myList;
                    } else
                        list[c].add(y);
                    break;
                case 2:
                    System.out.println(lastAnswer = list[c].get(y % list[c].size()));
                    break;
            }
        }
    }

}

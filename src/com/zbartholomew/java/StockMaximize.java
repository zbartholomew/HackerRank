package com.zbartholomew.java;

import java.util.Scanner;

public class StockMaximize {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = in.nextInt();
            int[] priceArray = new int[n];

            for (int j = 0; j < n; j++) {
                priceArray[j] = in.nextInt();
            }
            System.out.println(getMaxProfit(priceArray));
        }
        in.close();
    }

    private static long getMaxProfit(int[] priceArray) {
        long profit = 0L;
        int max = 0;

        // iterate backwards
        for (int i = priceArray.length - 1; i > -1; i--) {
            if (priceArray[i] >= max) {
                max = priceArray[i];
            }
            profit += max - priceArray[i];
        }
        return profit;
    }

}

package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/coin-change?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

import java.util.HashMap;
import java.util.Scanner;

public class CoinChangeProblem {

    private static long getWays(int money, int[] coins) {
        return getWays(money, coins, 0, new HashMap<>());
    }

    private static long getWays(int money, int[] coins, int index, HashMap<String, Long> memo) {

        if (money == 0) {
            return 1;
        }

        if (index >= coins.length) {
            return 0;
        }

        String key = money + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += getWays(remaining, coins, index + 1, memo);
            amountWithCoin += coins[index];
        }
        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for (int c_i = 0; c_i < m; c_i++) {
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
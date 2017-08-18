package com.zbartholomew.java;

import java.util.Scanner;

public class RedJohnIsBack {

    public static void main(String[] args) {
        long dp[] = new long[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 4];
        }

        long prime[] = new long[41];
        for (int i = 4; i <= 40; i++) {
            prime[i] = prime[i - 1];
            for (long j = dp[i - 1] + 1; j <= dp[i]; j++) {
                if (checkPrime(j)) {
                    prime[i]++;
                }
            }
        }

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            System.out.println(prime[a]);
        }
        in.close();
    }

    public static boolean checkPrime(long num) {
        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

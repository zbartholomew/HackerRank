package com.zbartholomew.java.WeekOfCode34;

import java.util.*;

/**
 * Created by Zach on 7/18/2017.
 */
public class MaximumGcdAndSum {

    static int maximumGcdAndSum(HashSet<Integer> A, HashSet<Integer> B) {

        int gcd, maxGcd = 1, sum = 1;

        // only ones were entered into the sets
        if (A.isEmpty() || B.isEmpty()) {
            return sum;
        }

        // precondition max gcd so we can remove some elements
        int maxA = Collections.max(A);
        int maxB = Collections.max(B);
        maxGcd = GCD(maxA, maxB, maxGcd);
        sum = maxA + maxB;

        // remove elements that are less than max gcd
        Iterator<Integer> itrA, itrB;

        itrA = A.iterator();
        while (itrA.hasNext()) {

            int a = itrA.next();

            if (a <= maxGcd) {
                itrA.remove();
                continue;
                // if b contains a and a > maxGcd then we know maxGcd is now a
            } else if (B.contains(a)) {
                maxGcd = a;
                sum = a + a;
                continue;
            }

            itrB = B.iterator();
            while (itrB.hasNext()) {
                int b = itrB.next();
                // remove element since we know it will no contribute to a max gcd
                // allows us to not loop as many times in the future
                if (b <= maxGcd) {
                    itrB.remove();
                    continue;
                }

                gcd = GCD(a, b, maxGcd);

                if (gcd > maxGcd) {
                    maxGcd = gcd;
                    sum = a + b;
                } else if (gcd == maxGcd && sum < (a + b)) {
                    sum = a + b;
                }

            }
        }

        return sum;
    }


    static int GCD(int x, int y, int maxGcd) {
        // Euclidean Algorithm
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
            // quit early if current gcd is less than max
            if (x < maxGcd) {
                return 0;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        for (int A_i = 0; A_i < n; A_i++) {
            int a = in.nextInt();
            if (a > 1) {
                A.add(a);
            }
        }
        for (int B_i = 0; B_i < n; B_i++) {
            int b = in.nextInt();
            if (b > 1) {
                B.add(b);
            }
        }

        int res = maximumGcdAndSum(A, B);
        System.out.println(res);
    }

}

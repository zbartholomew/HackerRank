package com.zbartholomew.java;

import java.util.Scanner;

public class EqualStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        int h1sum = 0;
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
            h1sum += h1[h1_i];
        }
        int h2[] = new int[n2];
        int h2sum = 0;
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
            h2sum += h2[h2_i];
        }
        int h3[] = new int[n3];
        int h3sum = 0;
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
            h3sum += h3[h3_i];
        }
        int h1index = 0;
        int h2index = 0;
        int h3index = 0;
        while ((h1sum != h2sum || h2sum != h3sum) && (h1sum != 0 && h2sum != 0 && h3sum != 0)) {

            if (h1sum > h2sum || h1sum > h3sum) {

                h1sum -= h1[h1index];
                ++h1index;

            } else if (h2sum > h3sum || h2sum > h1sum) {

                h2sum -= h2[h2index];
                ++h2index;

            } else if (h3sum > h1sum || h3sum > h2sum) {

                h3sum -= h3[h3index];
                ++h3index;

            }
        }
        if (h1sum != 0 && h2sum != 0 && h3sum != 0) {
            System.out.println(h1sum);
        } else {
            System.out.println(0);
        }
    }
}
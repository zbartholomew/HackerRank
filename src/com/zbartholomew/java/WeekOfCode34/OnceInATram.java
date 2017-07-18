package com.zbartholomew.java.WeekOfCode34;

import java.util.Scanner;

/**
 * Find first lucky ticket given tram ticket number 6-digits
 * lucky means sum of first three digits equal sum of last three
 */
public class OnceInATram {

    static String onceInATram(String s) {

        String[] arr = new String[2];
        int[] sum = new int[2];

        // split the ticket number into halves and store each half
        try {
            arr[0] = s.substring(0, 3);
            arr[1] = s.substring(3, 6);
        } catch (Exception e) {
            return "not length of 6";
        }

        for (int i = 0; i < arr.length; i++) {
            try {
                sum[i] = sum(Integer.parseInt(arr[i]));
            } catch (Exception e) {
                return "no integer in input";
            }
        }

//        System.out.println("first half: " + arr[0] + "\nsecond half: " + arr[1]);
//        System.out.println("sum of first half: " + sum[0] + "\nsum of second half: " + sum[1]);

        // if lucky ticket make unlucky so we can solve for the next lucky
        if (sum[0] == sum[1]) {
            arr[1] = Integer.toString(Integer.parseInt(arr[1]) + 1);
        }

        while (sum(Integer.parseInt(arr[0])) != sum(Integer.parseInt(arr[1]))) {
            s = Integer.toString(Integer.parseInt(s) + 1);
            arr[0] = s.substring(0, 3);
            arr[1] = s.substring(3, 6);
        }

        return arr[0] + arr[1];
    }

    static int sum(int temp) {
        int sum = 0;

        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String result = onceInATram(s);
        System.out.println(result);
    }
}

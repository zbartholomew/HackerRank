package com.zbartholomew.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zach on 7/21/2017.
 */
public class Test {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int maxStringLength = in.nextInt();

        List<String> splitStrings = new ArrayList<>();

        if (s.length() < maxStringLength) {
            System.out.println(s);
        } else {
            for (int i = 0; i < s.length(); i += maxStringLength) {

                if ((i + maxStringLength) < s.length()) {
                    splitStrings.add(s.substring(i, i + maxStringLength));
                } else {
                    splitStrings.add(s.substring(i, s.length() - 1));
                }
            }

            System.out.println(splitStrings);
        }

        System.out.println("\nSubstring test - This test string = " + "This test string".substring(0,4) + "substring(0,4)");
    }
}

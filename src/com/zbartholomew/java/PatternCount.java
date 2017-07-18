package com.zbartholomew.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern matching using RegEx
 */
public class PatternCount {

    static int patternCount(String s) {

        Pattern pattern = Pattern.compile("1[0]+(?=1)");
        Matcher matcher = pattern.matcher(s);

        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = patternCount(s);
            System.out.println(result);
        }
    }
}

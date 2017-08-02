package com.zbartholomew.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedBrackets {

    static String isBalanced(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.addFirst(s.charAt(i));
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return "NO";
                    }
                    if (stack.peekFirst() != '{') {
                        return "NO";
                    } else {
                        stack.removeFirst();
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return "NO";
                    }
                    if (stack.peekFirst() != '[') {
                        return "NO";
                    } else {
                        stack.removeFirst();
                    }
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return "NO";
                    }
                    if (stack.peekFirst() != '(') {
                        return "NO";
                    } else {
                        stack.removeFirst();
                    }
                    break;
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}

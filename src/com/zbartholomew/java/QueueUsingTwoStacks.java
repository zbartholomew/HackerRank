package com.zbartholomew.java;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numOfQueries = in.nextInt();

        for (int i = 0; i < numOfQueries; i++) {
            int type = in.nextInt();

            switch (type) {
                case 1:
                    stack1.push(in.nextInt());
                    break;
                case 2:
                    if (stack1.size() + stack2.size() == 0) {
                        break;
                    }
                    if (stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    stack2.pop();
                    break;
                case 3:
                    if (stack1.size() + stack2.size() == 0) {
                        break;
                    }
                    if (stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    System.out.println(stack2.peek());
                    break;
                default:
                    throw new IllegalArgumentException("Wrong type");
            }
        }
        in.close();
    }
}

package com.zbartholomew.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zach on 7/13/2017.
 */
public class JavaArrayList {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numLines = in.nextInt();

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        // adding to list
        for (int i = 0; i < numLines; i++) {
            int numInt = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>(numInt);

            for (int j = 0; j < numInt; j++) {
                list.add(in.nextInt());
            }

            lists.add(list);
        }

        // query from list
        int numQuery = in.nextInt();

        for (int k = 0; k < numQuery; k++) {
            int a = in.nextInt();
            int b = in.nextInt();

            try {
                System.out.println(lists.get(a-1).get(b-1).toString());
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}

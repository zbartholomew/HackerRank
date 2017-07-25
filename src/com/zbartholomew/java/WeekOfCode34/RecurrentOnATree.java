package com.zbartholomew.java.WeekOfCode34;

import java.util.*;

/**
 * Created by Zach on 7/20/2017.
 */
public class RecurrentOnATree {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        int sum;

        // creates the tree and shows the parent child relationships
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            tree = createVertices(x, y, tree);

        }

        // creates the values associated with the tree
        for (int j = 1; j <= n; j++) {
            valueMap.put(j, in.nextInt());
        }

        System.out.println(tree.toString());
        System.out.println(valueMap.toString());

        calculateSum(tree, valueMap);
    }

    private static TreeMap<Integer, ArrayList<Integer>> createVertices(int x, int y, TreeMap<Integer, ArrayList<Integer>> tree) {

        ArrayList<Integer> children = new ArrayList<>();

        // see if node in tree already has a child, if it does we want to add that child to our new children list then add y
        if (tree.containsKey(x)) {
            children = tree.get(x);
        }

        children.add(y);
        tree.put(x, children);

        return tree;
    }


    private static void calculateSum(TreeMap<Integer, ArrayList<Integer>> tree, HashMap<Integer, Integer> valueMap) {

        int sum = 0;

        for (Map.Entry<Integer, Integer> value : valueMap.entrySet()) {
            sum += value.getValue();
        }

        for (Map.Entry<Integer, ArrayList<Integer>> value : tree.entrySet()) {
            sum += value.getValue().get(0);
            sum += value.getValue().get(1);
        }

        System.out.println(sum);
    }


}

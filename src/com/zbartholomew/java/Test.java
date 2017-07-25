package com.zbartholomew.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Zach on 7/21/2017.
 */
public class Test {

    private static int counter = 1;

    private String name;
    private int id;

    public static Map<String, Test> map = new ConcurrentHashMap<>();

    public Test(String name, int id) {
        if (map.putIfAbsent(name, this) == null) {
            this.name = name;
            this.id = id;
            counter++;
        } else {
            throw new IllegalArgumentException("Product ID already exists.");
        }
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Test test0 = new Test("hello", 1);
        Test test1 = new Test("hello", 2);
        Test test2 = new Test("hello there", 1);

        System.out.println(map.get("hello").getName() + " and id " + map.get("hello").id);
        System.out.println(map.get("hello there").getName() + " and id " + map.get("hello").id);
    }

}

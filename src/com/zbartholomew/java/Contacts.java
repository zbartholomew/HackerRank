package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/contacts?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

import java.util.Scanner;

public class Contacts {

    public static class Node {

        private static final int NUMBER_OF_CHARACTERS = 26;
        // could use a hashmap instead
        Node[] children = new Node[NUMBER_OF_CHARACTERS];
        int size = 0;

        private static int getCharIndex(char c) {
            return c - 'a';
        }

        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }

        private void add(String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            size++;
            if (index == s.length()) {
                return;
            }

            char current = s.charAt(index);
//            int charCode = getCharIndex(current);

            Node child = getNode(current);
            if (child == null) {
                child = new Node();
                setNode(current, child);
            }

            child.add(s, index + 1);
        }

        private int findCount(String s, int index) {
            if (index == s.length()) {
                return size;
            }

            Node child = getNode(s.charAt(index));
            if (child == null) {
                return 0;
            }
            return child.findCount(s, index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node contacts = new Node();

        for (int i = 0; i < n; i++) {
            String operation = in.next();
            String name = in.next();

            switch (operation) {
                case "add":
                    contacts.add(name);
                    break;
                case "find":
                    System.out.println(contacts.findCount(name, 0));
                    break;
            }
        }
    }
}

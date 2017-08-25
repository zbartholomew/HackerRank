package com.zbartholomew.java;

import java.util.Scanner;

public class NoPrefixSet {

    static class Node {
        boolean eos;

        Node[] children;

        private static final int CHARACTER_RANGE = 'j' - 'a' + 1;

        Node() {
            this.eos = true;
            this.children = new Node[CHARACTER_RANGE];
        }
    }

    static class Trie {
        private Node root;

        Trie() {
            this.root = new Node();
        }

        // possibly add recursion like in Contacts.java
        public boolean add(String word) {
            Node node = root;
            int index = 0;
            while (index < word.length()) {
                node.eos = false;
                char c = word.charAt(index);
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new Node();
                } else if (node.children[i].eos || index == word.length() - 1) {
                    return false;
                }
                node = node.children[i];
                index++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            if (!trie.add(s)) {
                System.out.println("BAD SET");
                System.out.println(s);
                return;
            }
        }
        System.out.println("GOOD SET");
    }
}


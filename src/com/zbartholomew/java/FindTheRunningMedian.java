package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/find-the-running-median

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        in.close();

        double[] medians = getMedians(array);
        for (double median : medians) {
            System.out.println(median);
        }

    }

    private static double[] getMedians(int[] array) {

        // max heap containing lower numbers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b));

        // min heap containing higher numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double[] medians = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            addNum(num, maxHeap, minHeap);
            rebalance(maxHeap, minHeap);
            medians[i] = getMedian(maxHeap, minHeap);
        }

        return medians;
    }

    private static void addNum(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == 0 || number < maxHeap.peek()) {
            maxHeap.add(number);
        } else {
            minHeap.add(number);
        }
    }

    private static void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }

    }

    private static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }
}

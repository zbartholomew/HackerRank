package com.zbartholomew.java;

import java.util.*;


public class SortAndSplitArray {

    public static List<List<Integer>> sortAndSplit(int[] array, int numOfSlices) {
        Arrays.sort(array);
        int length = array.length;
        List<Integer> arrayAsList = new ArrayList<>();
        List<List<Integer>> arrayOfArrays = new ArrayList<>();

        for (int value : array) {
            arrayAsList.add(value);
        }

        if (length < numOfSlices || 0 > numOfSlices)
            throw new IllegalArgumentException("Error: length of integer array must be greater than 3");

        int remainder = length % 3;
        int sliceSize = length / numOfSlices;

//        Iterator<Integer> iter = arrayAsList.iterator();
//        for (int i = 0; i < numOfSlices; i++) {
//            arrayOfArrays.add(new ArrayList<>());
//
//            for (int j = 0; j < sliceSize; j++) {
//                arrayOfArrays.get(i).add(iter.next());
//            }
//            if (remainder > 0) {
//                arrayOfArrays.get(i).add(iter.next());
//                remainder -= 1;
//            }
//        }

        int temp = 0;
        for (int i = 0; i < numOfSlices; i++) {

            if (remainder > 0) {
                arrayOfArrays.add(arrayAsList.subList(temp, temp + sliceSize + 1));
                temp += sliceSize + 1;
                remainder -= 1;
            } else {
                arrayOfArrays.add(arrayAsList.subList(temp, temp + sliceSize));
                temp += sliceSize;
            }
        }


        return arrayOfArrays;

    }


    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(sortAndSplit(a, 3).toString());

        a = new int[]{2, 1, 4, 3};
        System.out.println(sortAndSplit(a, 3).toString());

        a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(sortAndSplit(a, 3).toString());

        a = new int[]{5, 4, 3, 2, 1, 4, 5, 4, 3};
        System.out.println(sortAndSplit(a, 3).toString());

        a = new int[]{5, 4, 3};
        System.out.println(sortAndSplit(a, 3).toString());

        a = new int[]{5, 4, 3, 5, 6, 8, 7, 5, 4, 3, 2, 1, 32, 4, 5, 5, 6, 5, 4, 3, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sortAndSplit(a, 3).toString());

        a = new int[]{5, 4, 3, 5, 6, 8, 7, 5, 4, 3, 2, 1, 32, 4, 5, 5, 6, 5, 4, 3, 2, 3, 4, 5, 6, 7, 8, 2};
        System.out.println(sortAndSplit(a, 3).toString());

        a = new int[]{5, 4, 3, 5, 6, 8, 7, 5, 4, 3, 2, 1, 32, 4, 5, 5, 6, 5, 4, 3, 2, 3, 4, 5, 6, 7, 8, 2, 3};
        System.out.println(sortAndSplit(a, 3).toString());
//
//        a = new int[]{1, 2};
//        System.out.println(sortAndSplit(a, 3).toString());

    }
}

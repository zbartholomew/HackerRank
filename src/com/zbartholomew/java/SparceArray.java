package com.zbartholomew.java;

// https://www.hackerrank.com/challenges/sparse-arrays?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=3-day-campaign

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SparceArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String[] a = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = in.next();
//        }
//
//        int q = in.nextInt();
//        for (int i = 0; i < q; i++) {
//            String query = in.next();
//            int count = 0;
//
//            for (int j = 0; j < a.length; j++) {
//                if (a[j].equals(query)) {
//                    count++;
//                }
//            }
//            System.out.println(count);
//        }
//        in.close();

        // functional programming with map
//        Map<String, Long> counterMap = Stream.generate(in::next)
//                .limit(in.nextInt())
//                .collect(groupingBy(identity(), counting()));
//
//        Stream.generate(in::next)
//                .limit(in.nextInt())
//                .map(query -> counterMap.getOrDefault(query, 0L))
//                .forEach(System.out::println);

        // functional programming with list
        List<String> strings = IntStream.range(0, in.nextInt())
                .mapToObj(i -> in.next())
                .collect(Collectors.toList());

        IntStream.range(0, in.nextInt())
                .mapToObj(i -> in.next())
                .mapToLong(q -> strings.stream()
                        .filter(q::equals)
                        .count())
                .forEach(System.out::println);
    }
}

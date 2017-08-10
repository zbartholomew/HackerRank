package com.zbartholomew.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckTour {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int totalDist = 0, totalPetro = 0;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int petroGiven = in.nextInt();
            int distance = in.nextInt();
            totalPetro += petroGiven;
            totalDist += distance;
            list.add(new int[]{petroGiven, distance});
        }
        in.close();

        if (totalDist > totalPetro) {
            System.out.println(0);
            return;
        }

        int count = 0, capacity = 0;
        for (int i = 0; i < n; i++) {
            int diff = list.get(i)[0] - list.get(i)[1];
            if (diff + capacity < 0) {
                count = i + 1;
                capacity = 0;
            } else {
                capacity += diff;
            }
        }

        System.out.println(count);
    }
}

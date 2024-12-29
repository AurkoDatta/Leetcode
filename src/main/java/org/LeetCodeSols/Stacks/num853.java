package org.LeetCodeSols.Stacks;

import java.util.Arrays;

public class num853 {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Pair position and speed, then sort by position in descending order
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]); // Sort by position descending

        // Calculate the time each car takes to reach the target
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        // Count fleets
        int fleets = 0;
        double prevTime = 0;

        for (int i = 0; i < n; i++) {
            // If the current car takes more time than the previous fleet's time,
            // it forms a new fleet
            if (times[i] > prevTime) {
                fleets++;
                prevTime = times[i]; // Update the time of the current fleet
            }
        }

        return fleets;
    }

    public static void main(String[] args) {
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleet(12, position, speed));



    }


}

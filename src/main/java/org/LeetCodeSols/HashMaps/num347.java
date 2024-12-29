package org.LeetCodeSols.HashMaps;

import java.util.*;

public class num347 {
    public int[] topKFrequent(int[] nums, int k) {
        // Create an array to store the result of the k most frequent elements
        int[] res = new int[k];

        // Create a HashMap to store the frequency of each element in the array
        // Key: the number from the array
        // Value: the frequency of that number
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // For each number in the array, update its frequency in the map
            // If the number is not already in the map, use 0 as the default value
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Create a PriorityQueue (a max-heap) to store the map entries sorted by frequency
        // The comparator ensures that the entry with the highest frequency is at the top of the heap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()) // Compare entries by their values (frequencies) in descending order
        );

        // Add all the entries from the map into the priority queue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry); // Add each entry (number and its frequency) to the heap
        }

        // Extract the top k elements from the priority queue
        for (int i = 0; i < k; i++) {
            // Remove the entry with the highest frequency from the heap
            // Get the key (the number) from the entry and store it in the result array
            res[i] = pq.poll().getKey();
        }

        // Return the result array containing the k most frequent elements
        return res;
    }
}

package org.LeetCodeSols.Set3;

public class num1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 18, 21, 25, 31, 36, 37, 39, 45, 52, 93, 102};
        int target = 76;

        System.out.println(twoSum(nums, target));
    }
}

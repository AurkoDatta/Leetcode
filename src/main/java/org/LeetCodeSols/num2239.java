package org.LeetCodeSols;

public class num2239 {
    public int findClosestNumber(int[] nums) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (Math.abs(nums[i]) <= Math.abs(result)) {
                if (Math.abs(nums[i]) == result){
                    result = Math.max(nums[i], result);
                }else {
                    result = nums[i];
                }
            }

        }
        return result;
    }
}

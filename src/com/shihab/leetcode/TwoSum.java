package com.shihab.leetcode;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (current + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 4}, 6)));
    }
}

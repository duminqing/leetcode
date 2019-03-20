package com.leetcode.dynamicprogramming;

public class _53 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int max = 0;
        int sub = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sub += nums[i];
            }
            if (sub < 0) {
                sub = 0;
            }
            if (sub > max) {
                max = sub;
            }
        }
        return max;
    }
}

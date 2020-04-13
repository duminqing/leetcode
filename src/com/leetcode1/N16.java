package com.leetcode1;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class N16 {
    public static void main(String[] args) {
        int y = new Solution().threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82);
        System.out.println(y);
    }


    /**
     * 双指针法
     */
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sum = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length; i++) {
                int L = i + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int curSum = nums[i] + nums[L] + nums[R];

                    if (Math.abs(curSum - target) < Math.abs(sum - target)) {
                        sum = curSum;
                    }
                    if (curSum < target) {
                        L++;
                    } else if (curSum > target) {
                        R--;
                    } else {
                        return sum;
                    }
                }
            }
            return sum;
        }
    }
}

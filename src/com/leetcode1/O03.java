package com.leetcode1;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class O03 {

    public static void main(String[] args) {
        int x = new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(x);
    }

    static class Solution {
        public int findRepeatNumber(int[] nums) {
            int[] x = new int[nums.length];
            x[0] = -1;

            for (int num : nums) {
                if (x[num] == num) {
                    return num;
                } else {
                    x[num] = num;
                }
            }
            return -1;
        }
    }
}

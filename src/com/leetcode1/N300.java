package com.leetcode1;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class N300 {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int max = 1;
            int[] dptable = new int[nums.length];
            dptable[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                int lastMax = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        lastMax = Math.max(lastMax, dptable[j]);
                    }
                }
                dptable[i] = lastMax + 1;
                max = Math.max(max, dptable[i]);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int x = new Solution().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        System.out.println();
        System.out.println(x);
    }
}

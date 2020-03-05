package com.leetcode;


/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class N53 {

    /**
     * 动态规划
     */
    static class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > 0) {
                    nums[i] += nums[i - 1];
                }
                maxSum = Math.max(nums[i], maxSum);
            }

            return maxSum;
        }
    }

    public static void main(String[] args) {
        int x = new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        // -2 1 1 4 4
        System.out.println(x);
    }
}

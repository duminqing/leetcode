package com.leetcode1;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class N343 {
    public static void main(String[] args) {
        int x = new Solution().integerBreak(2);
        System.out.println(x);
    }

    static class Solution {
        public int integerBreak(int n) {

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                for (int j = 2; j < i; j++) {
                    dp[i] = Math.max(Math.max(dp[i - j], i - j) * j, dp[i]);
                }
            }
            return dp[n];
        }
    }
}

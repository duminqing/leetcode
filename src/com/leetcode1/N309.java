package com.leetcode1;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class N309 {
    public static void main(String[] args) {
        int x = new Solution().maxProfit(new int[]{1, 2, 3, 0, 2});

        System.out.println(x);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            for (int i = 0; i < prices.length; i++) {
                if (i < 2) {
                    if (i == 0) {
                        dp[0][0] = 0;
                        dp[0][1] = -prices[0];
                    }
                    if (i == 1) {
                        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
                        dp[1][1] = Math.max(dp[0][1], -prices[1]);
                    }
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }
}

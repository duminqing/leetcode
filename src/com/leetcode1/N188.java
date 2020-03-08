package com.leetcode1;

public class N188 {
    public static void main(String[] args) {
        int x = new Solution().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});

        System.out.println(x);
    }

    static class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0 || k == 0) {
                return 0;
            }
            if (k > prices.length / 2) {
                return maxProfit(prices);
            }
            int[][][] dp = new int[prices.length][k][2];
            for (int i = 0; i < prices.length; i++) {
                for (int j = 0; j < k; j++) {
                    if (i == 0 || j == 0) {
                        if (i == 0) {
                            dp[i][j][0] = Math.max(0, Integer.MIN_VALUE + prices[i]);
                            dp[i][j][1] = Math.max(Integer.MIN_VALUE, -prices[i]);
                        } else {
                            dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                            dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                        }
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[prices.length - 1][k - 1][0];
        }

        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int[][] dp = new int[prices.length][2];
            for (int i = 0; i < prices.length; i++) {
                if (i == 0) {
                    dp[0][0] = 0;
                    dp[0][1] = -prices[0];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }
}

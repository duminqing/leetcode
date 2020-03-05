package com.leetcode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class N322 {
    /**
     * 动态规划の自下而上
     */
    static class Solution2 {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (coin <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

    /**
     * 动态规划の自顶向下
     */
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            return dp(coins, amount, new int[amount + 1]);
        }

        public int dp(int[] coins, int amount, int[] dptable) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            if (dptable[amount] != 0) {
                return dptable[amount];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int time = dp(coins, amount - coin, dptable);
                if (time >= 0 && time < min) {
                    min = time + 1;
                }
            }
            dptable[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
            return dptable[amount];
        }
    }

    public static void main(String[] args) {
        int x = new Solution2().coinChange(new int[]{2}, 3);
        System.out.println();
        System.out.println(x);
    }
}

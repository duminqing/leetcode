package com.leetcode1;

/**
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= n (总金额) <= 1000000
 */
public class M_08_11 {
    static class Solution {
        public int waysToChange(int n) {
            int[] coins = new int[]{1, 5, 10, 25};
            int mod = 1000000007;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int j = coin; j < n + 1; j++) {
                    dp[j] = (dp[j - coin] + dp[j]) % mod;
                }
            }
            return dp[n];
        }
    }
}

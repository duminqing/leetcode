package com.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class N70 {


    /**
     * 斐波那契数列，缓存三个值
     */
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int f1 = 1, f2 = 2, f3 = 3;
            for (int i = 3; i < n + 1; i++) {
                f3 = f2 + f1;
                f1 = f2;
                f2 = f3;

            }
            return f3;
        }
    }

    /**
     * 动态规划，构造一个N+1长度的DP table 做斐波那契数列
     */
    class Solution2 {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }


}

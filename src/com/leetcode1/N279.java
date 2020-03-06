package com.leetcode1;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class N279 {
    static class Solution {
        public int numSquares(int n) {
            int[] dptable = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dptable[i] = i;
                for (int j = 1; i - j * j >= 0; j++) {
                    dptable[i] = Math.min(dptable[i], dptable[i - j * j] + 1);
                }
            }
            return dptable[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(13));
    }
}

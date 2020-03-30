package com.leetcode1;

/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 */
public class N221 {
    /**
     * 动态规划
     */
    static class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int maxLen = 0;
            int len = matrix.length + 1;
            int wid = matrix[0].length + 1;
            int[][] dp = new int[len][wid];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                        maxLen = Math.max(maxLen, dp[i + 1][j + 1]);
                    }
                }
            }
            return maxLen * maxLen;
        }
    }

    public static void main(String[] args) {
        char[][] matrix = new char[4][5];
        matrix[0] = "10100".toCharArray();
        matrix[1] = "10111".toCharArray();
        matrix[2] = "11111".toCharArray();
        matrix[3] = "10010".toCharArray();
        new Solution().maximalSquare(matrix);

    }
}

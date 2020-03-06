package com.leetcode1;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class N62 {
    /**
     * 动态规划
     * <p>
     * 最佳 空间复杂度 O(n)
     */
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[] step = new int[n];
            step[0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0) {
                        step[j] += step[j - 1];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(step[i]);
            }
            return step[n - 1];
        }
    }

    /**
     * 动态规划
     * <p>
     * 空间复杂度 O(m*n)
     */
    static class Solution1 {
        public int uniquePaths(int m, int n) {
            int[][] step = new int[m][n];
            for (int i = 0; i < m; i++) {
                step[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                step[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    step[i][j] = step[i - 1][j] + step[i][j - 1];
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(step[i][j] + " ");
                }
                System.out.println();
            }
            return step[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(7, 3));
    }
}

package com.leetcode1;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class N63 {
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            obstacleGrid[0][0] = 1;
            for (int i = 1; i < row; i++) {
                if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] != 0) {
                    obstacleGrid[i][0] = 1;
                } else {
                    obstacleGrid[i][0] = 0;
                }
            }
            for (int i = 1; i < col; i++) {
                if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] != 0) {
                    obstacleGrid[0][i] = 1;
                } else {
                    obstacleGrid[0][i] = 0;
                }
            }
            System.out.println(obstacleGrid[0][0]);
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
            return obstacleGrid[row - 1][col - 1];
        }
    }

    public static void main(String[] args) {

        int[][] grid = new int[4][3];
        grid[1][1] = 1;
        //grid[0][1] = 1;
        int i = new Solution().uniquePathsWithObstacles(grid);
        System.out.println(i);
    }
}

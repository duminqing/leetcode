package com.leetcode1;

/**
 * 72. 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class N72 {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("abcf", "abad"));
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            int row = word1.length();
            int col = word2.length();
            int[][] dp = new int[row + 1][col + 1];
            for (int i = 0; i < row + 1; i++) {
                dp[i][0] = i;
            }

            for (int i = 0; i < col + 1; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i < row + 1; i++) {
                for (int j = 1; j < col + 1; j++) {
                    int left = dp[i - 1][j] + 1;
                    int down = dp[i][j - 1] + 1;
                    int leftDown = dp[i - 1][j - 1];
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        leftDown += 1;
                    }
                    dp[i][j] = Math.min(Math.min(left, down), leftDown);
                }
            }

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            return dp[row][col];
        }
    }
}

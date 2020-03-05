package com.leetcode;


import static java.util.Objects.isNull;

public class N1143 {
    /**
     * 1143. 最长公共子序列
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
     * <p>
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     * <p>
     * 若这两个字符串没有公共子序列，则返回 0。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     * 示例 2:
     * <p>
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc"，它的长度为 3。
     * 示例 3:
     * <p>
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0。
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= text1.length <= 1000
     * 1 <= text2.length <= 1000
     * 输入的字符串只含有小写英文字符。
     */
    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            if (isNull(text1) || isNull(text2) || "".equals(text1) || "".equals(text2)) {
                return 0;
            }
            int row = text1.length() + 1;
            int col = text2.length() + 1;
            int[][] subLen = new int[row][col];
            for (int i = 0; i < text1.length(); i++) {
                for (int j = 0; j < text2.length(); j++) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        subLen[i + 1][j + 1] = subLen[i][j] + 1;
                    } else {
                        subLen[i + 1][j + 1] = Math.max(subLen[i + 1][j], subLen[i][j + 1]);
                    }
                }
            }
            return subLen[row - 1][col - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("abc", "adbefc"));
    }

}

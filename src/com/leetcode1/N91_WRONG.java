package com.leetcode1;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class N91_WRONG {
    public static void main(String[] args) {
        int x = new Solution().numDecodings("1212");
        System.out.println(x);
    }

    static class Solution {
        public int numDecodings(String s) {
            if (s.charAt(0) == '0') {
                return 0;
            }
            int[] dp = new int[s.length()];
            dp[0] = 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') {
                        return 0;
                    }
                    if (i - 2 == -1) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 2];
                    }
                } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[dp.length - 1];
        }
    }
}

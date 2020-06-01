package com.leetcode1;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class N680 {
    public static void main(String[] args) {
        boolean b = new Solution().validPalindrome("abcddaca");
        System.out.println(b);
    }

    /**
     * 双指针
     */
    static class Solution {
        public boolean validPalindrome(String s) {
            int low = 0;
            int high = s.length() - 1;
            while (low < high) {
                if (s.charAt(low) == s.charAt(high)) {
                    low++;
                    high--;
                } else {
                    int low1 = low + 1;
                    int high1 = high;
                    boolean b1 = true;
                    while (low1 < high1) {
                        if (s.charAt(low1) != s.charAt(high1)) {
                            b1 = false;
                            break;
                        }
                        low1++;
                        high1--;
                    }

                    int low2 = low;
                    int high2 = high - 1;

                    boolean b2 = true;
                    while (low2 < high2) {
                        if (s.charAt(low2) != s.charAt(high2)) {
                            b2 = false;
                            break;
                        }
                        low2++;
                        high2--;
                    }
                    return b1 || b2;
                }
            }
            return true;

        }
    }
}

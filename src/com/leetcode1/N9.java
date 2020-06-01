package com.leetcode1;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class N9 {

    public static void main(String[] args) {
        boolean x = new Solution().isPalindrome(1234321);
        System.out.println(x);
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int tmp = x;
            int len = 0;
            while (tmp >= 1) {
                len++;
                tmp = tmp / 10;
            }
            int left = 0;
            int right = len - 1;
            while (left < right) {
                int head = x / (int) Math.pow(10, len - left - 1) %10;
                int tail = x % (int) Math.pow(10, left + 1) / (int) Math.pow(10, left);
                System.out.println(head + " " + tail);
                if (head != tail) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}

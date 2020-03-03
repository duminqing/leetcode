package com.leetcode;

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 */
public class N367 {
    static class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }
            int left = 2;
            int right = num / 2;
            while (left <= right) {
                int pivot = left + (right - left) / 2;
                long pivot2 = (long) pivot * pivot;
                if (pivot2 > num) {
                    right = pivot - 1;
                } else if (pivot2 < num) {
                    left = pivot + 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(14));

    }
}

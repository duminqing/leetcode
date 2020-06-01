package com.leetcode2;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class N69 {
    static class Solution {
        public int mySqrt(int x) {
            if (x < 2) {
                return x;
            }
            int left = 2;
            int right = x / 2;
            while (left <= right) {
                int pivot = left + (right - left) / 2;
                long num = (long) pivot * pivot;
                if (num > x) {
                    right = pivot - 1;
                } else if (num < x) {
                    left = pivot + 1;
                } else {
                    return pivot;
                }
            }
            return right;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}

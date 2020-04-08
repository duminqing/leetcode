package com.leetcode1;

/**
 * 263. 丑数
 * 编写一个程序判断给定的数是否为丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 * <p>
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 */
public class N263 {
    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(536870912));
    }

    static class Solution {
        public boolean isUgly(int num) {
            if (num == 0) {
                return false;
            }
            while (num % 2 == 0) {
                num /= 2;
            }
            while (num % 3 == 0) {
                num /= 3;
            }
            while (num % 5 == 0) {
                num /= 5;
            }
            return num == 1;
        }
    }
}



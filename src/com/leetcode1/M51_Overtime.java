package com.leetcode1;

/**
 * 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 */
public class M51_Overtime {
    public static void main(String[] args) {
        int x = new Solution().reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(x);
    }

    /**
     * 暴力破解超时
     */
    static class Solution {
        public int reversePairs(int[] nums) {
            int pairs = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        pairs++;
                    }
                }
            }
            return pairs;
        }
    }
}

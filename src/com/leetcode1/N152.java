package com.leetcode1;

/**
 * 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class N152 {

    static class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;
            int iMax = 1;
            int iMin = 1;
            for (int num : nums) {
                if (num < 0) {
                    int tmp = iMax;
                    iMax = iMin;
                    iMin = tmp;
                }
                iMax = Math.max(num, iMax * num);
                iMin = Math.min(num, iMin * num);
                max = Math.max(iMax, max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int x = new Solution().maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(x);
    }
}

package com.leetcode1;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class N4_TODO {

    public static void main(String[] args) {
        //new int[]{1, 3, 5, 7}
        double l = new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println("lalalal " + l);
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return 0;
        }
    }
}

package com.leetcode.dynamicprogramming;

public class MaximumSubarray_53 {
	public static void main(String[] args) {
		int[] nums = { -1, -2 };
		System.out.println(maxSubArray(nums));
		int[] nums2 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums2));
	}

	public static int maxSubArray(int[] nums) {
		int lastMax = 0;// 上一个最大值
		int max = nums[0]; // 当前最大值
		for (int num : nums) {
			lastMax = lastMax > 0 ? lastMax + num : num;
			if (max < lastMax) {
				max = lastMax;
			}
		}
		return max;
	}
}

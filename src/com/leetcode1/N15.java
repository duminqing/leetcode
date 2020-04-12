package com.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class N15 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println(lists);
    }

    /**
     * 双指针法
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null) {
                return new ArrayList<List<Integer>>();
            }
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            for (int curIndex = 0; curIndex < nums.length; curIndex++) {
                if (nums[curIndex] > 0) {
                    continue;
                }
                if (curIndex > 0 && nums[curIndex] == nums[curIndex - 1]) {
                    continue;
                }
                int minIndex = curIndex + 1;
                int maxIndex = nums.length - 1;
                while (minIndex < maxIndex) {
                    int sum = nums[minIndex] + nums[curIndex] + nums[maxIndex];
                    if (sum == 0) {
                        List<Integer> list = Arrays.asList(nums[curIndex], nums[minIndex], nums[maxIndex]);
                        lists.add(list);
                        while (minIndex < maxIndex && nums[minIndex] == nums[minIndex + 1]) {
                            minIndex++;
                        }
                        while (minIndex < maxIndex && nums[maxIndex] == nums[maxIndex - 1]) {
                            maxIndex--;
                        }
                        minIndex++;
                        maxIndex--;
                    } else if (sum < 0) {
                        minIndex++;
                    } else {
                        maxIndex--;
                    }
                }
            }
            return lists;
        }
    }
}

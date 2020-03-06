package com.leetcode1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N47 {
    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, used, list, new LinkedList<>());
        return list;
    }

    private void helper(int[] nums, boolean[] used, List<List<Integer>> resultList, LinkedList<Integer> list) {

        if (list.size() == nums.length) {
            resultList.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.addLast(nums[i]);
            used[i] = true;
            helper(nums, used, resultList, list);
            list.removeLast();
            used[i] = false;

        }
    }
}

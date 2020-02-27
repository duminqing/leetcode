package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class N46_2 {
    /**
     * 46. 全排列
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();

        helper(nums, list, new LinkedList<>());
        return list;

    }

    private void helper(int[] nums, List<List<Integer>> resultList, LinkedList<Integer> list) {

        if (list.size() == nums.length) {
            resultList.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.addLast(nums[i]);
                helper(nums, resultList, list);
                list.removeLast();
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        helper2(nums, used, list, new LinkedList<>());
        return list;

    }

    private void helper2(int[] nums, boolean[] used, List<List<Integer>> resultList, LinkedList<Integer> list) {

        if (list.size() == nums.length) {
            resultList.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            list.addLast(nums[i]);
            used[i] = true;
            helper2(nums, used, resultList, list);
            list.removeLast();
            used[i] = false;
        }
    }
}

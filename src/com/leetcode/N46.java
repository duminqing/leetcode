package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N46 {
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
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list, new LinkedList<>());
        System.out.println(list);
        return list;
    }

    void helper(int[] nums, List<List<Integer>> resultList, LinkedList<Integer> list) {
        if (nums.length == list.size()) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.addLast(num);
            helper(nums, resultList, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        N46 n46 = new N46();
        n46.permute(new int[]{1, 2, 3});
    }
}

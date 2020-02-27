package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class N78 {
    /**
     * 78. 子集
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     */


    /**
     *
     * @param first 为了防止出现 [12][21]这种情况
     * @param len
     * @param output
     * @param curr
     * @param nums
     */
    public void backtrack(int first, int len, List<List<Integer>> output, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == len) {
            System.out.println(curr);
            output.add(new ArrayList<>(curr));
        }

        for (int i = first; i < nums.length; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, len, output, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        // 子集长度 按0/1/2/3
        for (int len = 0; len < nums.length + 1; ++len) {
            backtrack(0, len, output, new ArrayList<>(), nums);
        }
        return output;
    }

    public static void main(String[] args) {
        N78 n78 = new N78();
        System.out.println(n78.subsets(new int[]{1, 2, 3}));
    }
}

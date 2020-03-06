package com.leetcode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N77 {
    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * <p>
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        helper(n, k, 1, resultList, new Stack<>());
        return resultList;
    }

    public void helper(int n, int k, int start, List<List<Integer>> resultList, Stack<Integer> stack) {
        if (stack.size() == k) {
            resultList.add(new ArrayList<>(stack));
            return;
        }
        for (; start < n + 1; start++) {
            stack.add(start);
            helper(n, k, start + 1, resultList, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        N77 n77 = new N77();
        System.out.println(n77.combine(4, 2));
    }
}

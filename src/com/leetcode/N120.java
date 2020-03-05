package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * * [2],
 * * [3,4],
 * * [6,5,7],
 * * [4,1,8,3]
 * <p>
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */

public class N120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(9, 10, 11, 1));
        int x = new Solution().minimumTotal(triangle);
        System.out.println(x);
    }

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> col = triangle.get(i);
                List<Integer> lastCol = triangle.get(i - 1);
                for (int j = 0; j < col.size(); j++) {
                    if (j == 0) {
                        col.set(j, lastCol.get(j) + col.get(j));
                    } else if (j == lastCol.size()) {
                        col.set(j, lastCol.get(j - 1) + col.get(j));
                    } else {
                        col.set(j, Math.min(lastCol.get(j - 1), lastCol.get(j)) + col.get(j));
                    }
                }
            }
            return triangle.get(triangle.size() - 1).stream().mapToInt(Integer::intValue).min().orElse(0);
        }
    }
}

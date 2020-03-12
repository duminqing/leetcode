package com.leetcode1;

import java.util.*;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class N56 {
    public static void main(String[] args) {

        int[][] a = new int[2][2];
        a[0] = new int[]{2, 4};
        a[1] = new int[]{1, 3};

        int[][] x = new Solution().merge(a);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.print(x[i][j] + " ");
            }
        }
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            LinkedList<int[]> list = new LinkedList<>();
            for (int i = 0; i < intervals.length; i++) {
                if (list.isEmpty() || intervals[i][0] > list.getLast()[1]) {
                    list.add(intervals[i]);
                } else {
                    list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
                }
            }
            return list.toArray(new int[list.size()][2]);
        }
    }
}

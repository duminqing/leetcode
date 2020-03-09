package com.leetcode1;

import com.leetcode1.helper.UnionFind;

public class N547_2 {
    public static void main(String[] args) {
        int[][] nums = new int[5][5];
        nums[0] = new int[]{1, 1, 0, 0, 0};
        nums[1] = new int[]{1, 1, 0, 0, 0};
        nums[2] = new int[]{0, 0, 1, 1, 0};
        nums[3] = new int[]{0, 0, 1, 1, 0};
        nums[4] = new int[]{0, 0, 0, 0, 1};

        int len = nums.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        System.out.println(unionFind.getCount());
    }
}

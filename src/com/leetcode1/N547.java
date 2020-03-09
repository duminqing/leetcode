package com.leetcode1;

import java.util.Arrays;

public class N547 {
    static class Solution {

        int find(int[] parent, int i) {
            if (parent[i] == -1) {
                return i;
            }
            return find(parent, parent[i]);
        }

        void union(int[] parent, int x, int y) {
            int xset = find(parent, x);
            int yset = find(parent, y);

            if (xset != yset) {
                parent[xset] = yset;
            }
        }

        public int findCircleNum(int[][] m) {
            int[] parent = new int[m.length];
            Arrays.fill(parent, -1);
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    if (m[i][j] == 1 && i != j) {
                        union(parent, i, j);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                System.out.print(parent[i] + " ");
                if (parent[i] == -1) {
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        nums[0] = new int[]{1, 1, 0};
        nums[1] = new int[]{1, 1, 0};
        nums[2] = new int[]{0, 0, 1};
        int x = new Solution().findCircleNum(nums);
        System.out.println();
        System.out.println(x);
    }
}

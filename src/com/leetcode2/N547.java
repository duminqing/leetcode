package com.leetcode2;

public class N547 {
    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        nums[0] = new int[]{1, 1, 0};
        nums[1] = new int[]{1, 1, 0};
        nums[2] = new int[]{0, 0, 1};
        int x = new Solution().findCircleNum(nums);
        System.out.println();
        System.out.println(x);
    }

    static class Solution {
        public int findCircleNum(int[][] M) {
            int len = M.length;
            UnionFind unionFind = new UnionFind(len);
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (M[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
            return unionFind.count;
        }

        class UnionFind {
            private int count;
            private int[] parent;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }
                parent[rootP] = rootQ;
                count--;
            }
        }
    }


}

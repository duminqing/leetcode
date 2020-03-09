package com.leetcode1;

import java.util.*;

/**
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */
public class N200 {


    /**
     * 方案1 采用深度优先搜索
     */
    class Solution1 {


        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int num = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        num++;
                        dfs(grid, i, j);
                    }
                }
            }
            return num;
        }

        private void dfs(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }

    /**
     * 方案1 采用广度优先搜索
     */
    static class Solution2 {


        public int numIslands(char[][] grid) {

            if (grid == null || grid.length == 0) {
                return 0;
            }
            int row = grid.length;
            int col = grid[0].length;
            System.out.println(row + "  " + col);
            int num = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        num++;
                        grid[i][j] = '0';
                        Deque<Integer> deque = new ArrayDeque<>();
                        deque.addLast(i * col + j);
                        while (!deque.isEmpty()) {
                            int xy = deque.removeFirst();

                            int x = xy / col;
                            int y = xy % col;
                            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                                deque.addLast((x - 1) * col + y);
                                grid[x - 1][y] = '0';
                            }
                            if (x + 1 < row && grid[x + 1][y] == '1') {
                                deque.addLast((x + 1) * col + y);
                                grid[x + 1][y] = '0';
                            }
                            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                                deque.addLast(x * col + y - 1);
                                grid[x][y - 1] = '0';
                            }
                            if (y + 1 < col && grid[x][y + 1] == '1') {
                                deque.addLast(x * col + y + 1);
                                grid[x][y + 1] = '0';
                            }
                        }
                    }
                }
            }
            return num;
        }

    }

    /**
     * 使用查并集
     */
    static class Solution3 {
        static class UnionFind {
            private int count;
            private int[] parent;

            public UnionFind(char[][] grid) {
                int row = grid.length;
                int col = grid[0].length;
                parent = new int[row * col];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (grid[i][j] == '1') {
                            parent[i * col + j] = i * col + j;
                            count++;
                        }
                    }
                }
            }

            private int find(int i) {
                while (parent[i] != i) {
                    parent[i] = parent[parent[i]];
                    i = parent[i];
                }
                return i;
            }

            public void union(int i, int j) {
                int ii = find(i);
                int jj = find(j);
                if (ii != jj) {
                    parent[ii] = jj;
                    count--;
                }
            }

            public int getCount() {
                return count;
            }
        }

        public int numIslands(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            UnionFind unionFind = new UnionFind(grid);
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    if (grid[x][y] == '1') {
                        grid[x][y] = '0';
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            unionFind.union(x * col + y, (x - 1) * col + y);
                        }
                        if (x + 1 < row && grid[x + 1][y] == '1') {
                            unionFind.union(x * col + y, (x + 1) * col + y);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            unionFind.union(x * col + y, x * col + y - 1);
                        }
                        if (y + 1 < col && grid[x][y + 1] == '1') {
                            unionFind.union(x * col + y, x * col + y + 1);
                        }
                    }
                }
            }
            return unionFind.getCount();
        }
    }

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        char[][] grid = new char[4][5];
        grid[0] = "11000".toCharArray();
        grid[1] = "11000".toCharArray();
        grid[2] = "00100".toCharArray();
        grid[3] = "00011".toCharArray();
        int x = solution2.numIslands(grid);
        System.out.println(x);
    }
}

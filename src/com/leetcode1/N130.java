package com.leetcode1;

/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class N130 {
    /**
     * 查并集
     */
    static class Solution {

        class UnionFind {

            private int[] parent;

            public UnionFind(int len) {
                // 多加入一个虚拟节点，让所有边缘0连到该节点上
                this.parent = new int[len + 1];
                for (int i = 0; i < len + 1; i++) {
                    parent[i] = i;
                }
            }

            private void union(int x, int y) {
                int nodeX = find(x);
                int nodeY = find(y);
                if (nodeX != nodeY) {
                    parent[nodeX] = nodeY;
                }
            }

            private int find(int i) {
                while (i != parent[i]) {
                    parent[i] = parent[parent[i]];
                    i = parent[i];
                }
                return i;
            }

            public boolean isConnected(int i, int j) {
                return find(i) == find(j);
            }
        }

        public void solve(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            int len = row * col;
            UnionFind unionFind = new UnionFind(len);

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                            unionFind.union(i * col + j, len);
                        } else {
                            if (board[i - 1][j] == 'O') {
                                unionFind.union(i * col + j, (i - 1) * col + j);
                            }
                            if (i < row - 1 && board[i + 1][j] == 'O') {
                                unionFind.union(i * col + j, (i + 1) * col + j);
                            }
                            if (board[i][j - 1] == 'O') {
                                unionFind.union(i * col + j, i * col + j - 1);
                            }
                            if (j < col - 1 && board[i][j + 1] == 'O') {
                                unionFind.union(i * col + j, i * col + j + 1);
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (unionFind.isConnected(unionFind.parent.length - 1, i * col + j)) {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        char[][] a = new char[6][5];
        a[0] = "XOXXX".toCharArray();
        a[1] = "XOXXX".toCharArray();
        a[2] = "XOOXX".toCharArray();
        a[3] = "XXXXX".toCharArray();
        a[4] = "XOOOX".toCharArray();
        a[5] = "XXXXX".toCharArray();
        new Solution().solve(a);
    }
}

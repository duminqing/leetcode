package com.leetcode1.helper;

public class UnionFind {
    private int count;
    private int[] parent;

    public UnionFind(int len) {
        this.count = len;
        this.parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            parent[x] = y;
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

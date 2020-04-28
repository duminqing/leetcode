package com.leetcode1;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class N429 {
    static class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Deque<Node> deque = new ArrayDeque<>();
            deque.add(root);
            List<List<Integer>> levelList = new ArrayList<>();
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> level = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    Node node = deque.removeFirst();
                    level.add(node.val);
                    deque.addAll(node.children);
                }
                levelList.add(level);
            }
            return levelList;
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}

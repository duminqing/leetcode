package com.leetcode1;

import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class N114 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        new Solution().flatten(node1);
        System.out.println(node1);

    }

    static class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            dfs(root, stack);
            TreeNode later = stack.pop();
            TreeNode former;
            while (!stack.isEmpty()) {
                former = stack.pop();
                former.right = later;
                former.left = null;
                later = former;
            }
        }

        void dfs(TreeNode root, Stack<TreeNode> stack) {
            if (root == null) {
                return;
            }
            stack.add(root);
            dfs(root.left, stack);
            dfs(root.right, stack);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

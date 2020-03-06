package com.leetcode1;

import com.leetcode.bean.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class N102 {

    // **********************************************************************************
    // 这个方法看起来不好
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        bfs(root, resultList, 0);
        return resultList;
    }

    public void bfs(TreeNode node, List<List<Integer>> resultList, int level) {
        if (resultList.size() == level) {
            resultList.add(new ArrayList<>());
        }
        resultList.get(level).add(node.val);
        if (node.left != null) {
            bfs(node.left, resultList, level + 1);
        }
        if (node.right != null) {
            bfs(node.right, resultList, level + 1);
        }
    }

    // **********************************************************************************
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int levelLength = deque.size();
            List<Integer> result = new ArrayList<>(levelLength);
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = deque.removeFirst();
                result.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            resultList.add(result);
        }
        return resultList;
    }
}

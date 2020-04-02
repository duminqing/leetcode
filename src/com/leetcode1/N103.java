package com.leetcode1;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class N103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        List<List<Integer>> list = new Solution().zigzagLevelOrder(root);
        System.out.println(list);
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> levelList = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            boolean left = true;

            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> level = new LinkedList<>();
                while (size > 0) {
                    TreeNode node = deque.removeFirst();
                    if (left) {
                        level.add(node.val);
                    } else {
                        level.add(0, node.val);
                    }
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    size--;
                }
                left = !left;
                levelList.add(level);
            }
            return levelList;
        }
    }
}

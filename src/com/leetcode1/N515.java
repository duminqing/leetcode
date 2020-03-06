package com.leetcode1;

import com.leetcode.bean.TreeNode;

import java.util.*;

public class N515 {
    /**
     * 515. 在每个树行中找最大值
     * 您需要在二叉树的每一行中找到最大的值。
     *
     * 示例：
     *
     * 输入:
     *
     *           1
     *          / \
     *         3   2
     *        / \   \
     *       5   3   9
     *
     * 输出: [1, 3, 9]
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int length = deque.size();
            int max = deque.getFirst().val;
            for (int i = 0; i < length; i++) {
                TreeNode current = deque.removeFirst();
                max = Math.max(max, current.val);

                if (current.left != null) {
                    deque.addLast(current.left);
                }
                if (current.right != null) {
                    deque.addLast(current.right);
                }
            }
            resultList.add(max);
        }
        return resultList;
    }

}

package com.leetcode;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N144_2 {
    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     * <p>
     *  示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> valueList = new ArrayList<>();

        if (root == null) {
            return valueList;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            valueList.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return valueList;
    }
}

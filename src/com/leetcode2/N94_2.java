package com.leetcode2;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class N94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> valueList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                valueList.add(current.val);
                current = current.right;
            }
        }
        return valueList;
    }
}

package com.leetcode2;

import com.leetcode.bean.TreeNode;

public class N98_2 {
    public static void main(String[] args) {
        System.out.println(true && false);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && lower >= val) {
            return false;
        }
        if (upper != null && upper <= val) {
            return false;
        }
        if (!helper(root.right, val, upper)) {
            return false;
        }
        if (!helper(root.left, lower, val)) {
            return false;
        }
        return true;
    }

    private boolean helper2(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        return (lower == null || lower < val)
                && (upper == null || upper > val)
                && helper(root.right, val, upper)
                && helper(root.left, lower, val);
    }

}

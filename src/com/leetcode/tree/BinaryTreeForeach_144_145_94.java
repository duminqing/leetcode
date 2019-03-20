package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 使用栈对二叉树进行遍历
public class BinaryTreeForeach_144_145_94 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build();
        // 先序遍历
        System.out.println("先序遍历" + pre(root));
        // 中序遍历
        System.out.println("中序遍历" + mid(root));
        // 后序遍历
        System.out.println("后序遍历" + after(root));
    }

    private static List<Character> after(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            // 注意这里是插入首位，否则需要将list逆转
            list.add(0, node.value);
        }
        return list;
    }

    private static List<Character> mid(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                list.add(curr.value);
                curr = curr.right;
            }
        }
        return list;
    }

    private static List<Character> pre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.value);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }
}

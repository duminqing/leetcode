package com.leetcode1;

import com.leetcode.bean.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class N106 {

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().buildTree(new int[]{2, 1}, new int[]{2, 1});
        System.out.println();
    }

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (postorder.length == 0 || inorder.length == 0) {
                return null;
            }
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if (inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postEnd]);
            if (postStart == postEnd) {
                return root;
            }
            int index = inStart;
            while (inorder[index] != postorder[postEnd] && index <= inEnd) {
                index++;
            }
            root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + index - inStart - 1);
            root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + index - inStart, postEnd - 1);

            return root;
        }
    }
}

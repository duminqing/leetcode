package com.leetcode;

import com.leetcode.bean.TreeNode;

public class N105_1 {
    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */


    public N105_1() {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return treeNode;
        }

        int nodeIndex = inStart;
        while (inorder[nodeIndex] != preorder[preStart] && nodeIndex <= inEnd) {
            nodeIndex++;
        }

        int len = nodeIndex - inStart;
        if (nodeIndex > inStart) {
            treeNode.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, nodeIndex - 1);
        }
        if (nodeIndex < inEnd) {
            treeNode.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, nodeIndex + 1, inEnd);
        }

        return treeNode;
    }

    public static void main(String[] args) {
        N105_1 n105 = new N105_1();
        n105.buildTree(new int[]{3, 9, 8, 12, 20, 15, 7}, new int[]{8, 9, 12, 3, 15, 20, 7});
    }
}

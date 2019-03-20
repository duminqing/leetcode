package com.leetcode.tree;

public class TreeNode {
    protected char value;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(char value) {
        this.value = value;
    }

    public static TreeNode build() {
        TreeNode a = new TreeNode('a');

        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        a.setLeft(b);
        a.setRight(c);
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        b.setLeft(d);
        b.setRight(e);
        TreeNode f = new TreeNode('f');
        TreeNode g = new TreeNode('g');
        c.setLeft(f);
        c.setRight(g);
        return a;
    }

    public char getValue() {
        return value;
    }

    public TreeNode setValue(char value) {
        this.value = value;
        return this;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }
}

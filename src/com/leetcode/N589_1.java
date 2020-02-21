package com.leetcode;

import com.leetcode.bean.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class N589_1 {
    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * <p>
     * 例如，给定一个 3叉树 :
     * <p>
     * 返回其前序遍历: [1,3,5,6,2,4]。
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> valueList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            valueList.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return valueList;
    }
}

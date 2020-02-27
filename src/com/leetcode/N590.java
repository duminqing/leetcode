package com.leetcode;

import com.leetcode.bean.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class N590 {
    /**
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     * <p>
     * 例如，给定一个 3叉树 :
     * <p>
     * 返回其后序遍历: [5,6,3,2,4,1].
     */

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> valueList = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node.children != null && node.children.size() > 0) {
                for (Node n : node.children) {
                    stack.push(n);
                }
            }
            valueList.add(0, node.val);
        }

        return valueList;
    }
}

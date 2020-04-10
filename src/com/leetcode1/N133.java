package com.leetcode1;

import java.util.*;

/**
 * 133. 克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */
public class N133 {
    /**
     * 使用广度优先搜索算法
     */
    class Solution2 {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }
            Map<Node, Node> visited = new HashMap<>();
            Deque<Node> queue = new LinkedList<>();
            queue.addLast(node);
            visited.put(node, new Node(node.val));

            while (!queue.isEmpty()) {
                Node curr = queue.removeFirst();
                for (Node neighbor : curr.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, new Node(neighbor.val));
                        queue.add(neighbor);
                    }
                    visited.get(curr).neighbors.add(visited.get(neighbor));
                }
            }
            return visited.get(node);
        }
    }

    /**
     * 使用深度优先搜索算法
     */
    static class Solution {
        Map<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }
            if (visited.containsKey(node)) {
                return visited.get(node);
            }
            Node clone = new Node(node.val);
            visited.put(node, clone);
            for (Node child : node.neighbors) {
                clone.neighbors.add(cloneGraph(child));
            }
            return clone;
        }
    }


    static class Node {
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return val == node.val;
        }

        @Override
        public int hashCode() {
            return val;
        }

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}

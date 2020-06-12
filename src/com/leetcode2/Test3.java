package com.leetcode2;

import java.util.*;

public class Test3 {
    static class Node {
        Node left;
        Node right;
        Node up;
        Node down;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Node n00 = new Node(0);
        Node n01 = new Node(1);
        Node n10 = new Node(2);
        Node n11 = new Node(3);
        n00.down = n10;
        n00.right = n01;
        n01.down = n11;
        n10.right = n11;
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(n00);
        Set<Node> visited = new HashSet<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node cur = deque.removeFirst();
                if (cur.right != null && !visited.contains(cur.right)) {
                    deque.addLast(cur.right);
                    visited.add(cur.right);
                }
                if (cur.down != null && !visited.contains(cur.down)) {
                    deque.addLast(cur.down);
                    visited.add(cur.down);
                }
                System.out.println(cur.val);
            }
        }

    }

}

package com.leetcode1;

import java.util.*;

/**
 * 433. 最小基因变化
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * <p>
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * <p>
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * <p>
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * <p>
 * 注意:
 * <p>
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 * <p>
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * <p>
 * 返回值: 1
 * 示例 2:
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * 返回值: 2
 * 示例 3:
 * <p>
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * 返回值: 3
 */
public class N433 {

    /**
     * BDF
     */
    static class Solution {
        static public int minMutation(String start, String end, String[] bank) {
            if (bank.length == 0) {
                return -1;
            }
            Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
            if (!bankSet.contains(end)) {
                return -1;
            }
            char[] gene = new char[]{'A', 'C', 'G', 'T'};
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            Set<String> visited = new HashSet<>();
            visited.add(start);

            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    String s = queue.remove();
                    char[] chars = s.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char c0 = chars[i];
                        for (char c : gene) {
                            chars[i] = c;
                            String newGene = new String(chars);
                            if (visited.contains(newGene)) {
                                continue;
                            }
                            if (newGene.equals(end)) {
                                return count + 1;
                            }
                            if (bankSet.contains(newGene)) {
                                visited.add(newGene);
                                queue.add(newGene);
                            }
                        }
                        chars[i] = c0;
                    }
                    size--;
                }
                count++;
            }
            return -1;
        }
    }

    /**
     * 双向BDF
     */
    static class Solution2 {
        static public int minMutation(String start, String end, String[] bank) {
            if (bank.length == 0) {
                return -1;
            }
            Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
            if (!bankSet.contains(end)) {
                return -1;
            }
            bankSet.add(start);

            char[] gene = new char[]{'A', 'C', 'G', 'T'};
            // ************************************
            Queue<String> queue1 = new LinkedList<>();
            Set<String> visited1 = new HashSet<>();
            queue1.add(start);
            visited1.add(start);

            Queue<String> queue2 = new LinkedList<>();
            Set<String> visited2 = new HashSet<>();
            queue2.add(end);
            visited2.add(end);

            int count = 0;
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                count++;
                if (queue1.size() > queue2.size()) {
                    Queue<String> queue = queue2;
                    queue2 = queue1;
                    queue1 = queue;

                    Set<String> visited = visited2;
                    visited2 = visited1;
                    visited1 = visited;
                }
//                System.out.println("queue1 = " + queue1);
//                System.out.println("queue2 = " + queue2);
//                System.out.println("visited1 = " + visited1);
//                System.out.println("visited2 = " + visited2);
                int size = queue1.size();
                while (size-- > 0) {
                    String s = queue1.remove();
                    char[] chars = s.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char c0 = chars[i];
                        for (char c : gene) {
                            chars[i] = c;
                            String newGene = new String(chars);
//                            System.out.println("newGene = " + newGene);
                            if (visited1.contains(newGene)) {
                                continue;
                            }
                            if (visited2.contains(newGene)) {
//                                System.out.println("hhhhhh");
                                return count;
                            }
                            if (bankSet.contains(newGene)) {
                                visited1.add(newGene);
                                queue1.add(newGene);
                            }
                        }
                        chars[i] = c0;
                    }
                }
            }
            // ************************************
            return -1;
        }
    }

    public static void main(String[] args) {
        int x = Solution2.minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AAACCCCC", "AACCCCCC", "ACCCCCCC", "CCCCCCCC"});
        System.out.println(x);
    }
}

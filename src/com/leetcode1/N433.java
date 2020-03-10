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

    public static void main(String[] args) {
        int x = Solution.minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"});
        System.out.println(x);
    }
}

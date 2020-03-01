package com.leetcode;

import java.util.*;

public class N127 {
    /**
     * 127. 单词接龙
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     * <p>
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     * <p>
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * 示例 1:
     * <p>
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * 输出: 5
     * <p>
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * 返回它的长度 5。
     * 示例 2:
     * <p>
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * 输出: 0
     * <p>
     * 解释: endWord "cog" 不在字典中，所以无法进行转换。
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(beginWord);
        Set<String> visited = new HashSet<>();
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String node = deque.removeFirst();
                if (node.equals(endWord)) {
                    level++;
                    return level;
                }
                for (String word : wordList) {
                    if (visited.contains(word)) {
                        continue;
                    }
                    if (isOneCharDiff(node, word)) {
                        deque.addLast(word);
                        visited.add(word);
                    }
                }
                visited.add(node);
            }
            level++;
        }
        return 0;
    }


    static boolean isOneCharDiff(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        //  System.out.println(isOneCharDiff("hit", "hot"));
//        System.out.println(isOneCharDiff("abc", "abc"));
//        System.out.println(isOneCharDiff("abccc", "abcdd"));


//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        System.out.println(ladderLength(beginWord, endWord, wordList));


        System.out.println(ladderLength("a", "b", Arrays.asList("a", "b", "c")));
        System.out.println(ladderLength("hi", "ge", Arrays.asList("hi", "ge")));
    }
}

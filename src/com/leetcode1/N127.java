package com.leetcode1;

import java.util.*;

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
public class N127 {
    /**
     * 广度优先算法
     */
    static class Solution {
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
    }

    /**
     * 双向BFS
     */
    static class Solution2 {
        public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }
            wordList.add(beginWord);
            // 从两端BFS遍历要用的队列
            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();
            queue1.offer(beginWord);
            queue2.offer(endWord);
            // 两端已经遍历过的节点
            Set<String> visited1 = new HashSet<>();
            Set<String> visited2 = new HashSet<>();
            visited1.add(beginWord);
            visited2.add(endWord);

            int count = 0;
            Set<String> allWordSet = new HashSet<>(wordList);

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                count++;
                if (queue1.size() > queue2.size()) {
                    Queue<String> tmpQueue = queue1;
                    queue1 = queue2;
                    queue2 = tmpQueue;

                    Set<String> tmpSet = visited1;
                    visited1 = visited2;
                    visited2 = tmpSet;
                }
                int size1 = queue1.size();
                while (size1-- > 0) {
                    String s = queue1.remove();
                    char[] chars = s.toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        char c0 = chars[j];
                        for (char c = 'a'; c < 'z'; c++) {
                            chars[j] = c;
                            String newS = new String(chars);
                            if (visited1.contains(newS)) {
                                continue;
                            }
                            if (visited2.contains(newS)) {
                                return count + 1;
                            }
                            if (allWordSet.contains(newS)) {
                                queue1.offer(newS);
                                visited1.add(newS);
                            }
                        }
                        chars[j] = c0;
                    }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {

        System.out.println(Solution2.ladderLength("a", "b", new ArrayList<>(Arrays.asList("a", "b", "c"))));
        System.out.println(Solution2.ladderLength("hi", "ge",new ArrayList<>( Arrays.asList("hi", "ge"))));
    }
}

package com.leetcode2;

import java.util.*;

public class N127 {
    static class Solution2 {
        public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }
            // 因为正反方向都需要终止
            wordList.add(beginWord);
            Set<String> allWordSet = new HashSet<>(wordList);
            // 正向初始化
            Queue<String> queue1 = new LinkedList<>();
            Set<String> visited1 = new HashSet<>();
            queue1.add(beginWord);
            visited1.add(beginWord);
            // 反向初始化
            Queue<String> queue2 = new LinkedList<>();
            Set<String> visited2 = new HashSet<>();
            queue2.add(endWord);
            visited2.add(endWord);

            // 计数器
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

                int size = queue1.size();
                while (size-- > 0) {
                    String s = queue1.remove();
                    char[] chars = s.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char tmp = chars[i];
                        for (char c = 'a'; c < 'z'; c++) {
                            chars[i] = c;
                            String s0 = new String(chars);
                            if (visited1.contains(s0)) {
                                continue;
                            }
                            if (visited2.contains(s0)) {
                                return count + 1;
                            }
                            if (allWordSet.contains(s0)) {
                                queue1.add(s0);
                                visited1.add(s0);
                            }
                        }
                        // 还原
                        chars[i] = tmp;
                    }
                }
            }
            return 0;
        }
    }
}

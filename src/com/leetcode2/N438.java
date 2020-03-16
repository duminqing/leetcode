package com.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class N438 {
    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();


            int left = 0, right = 0;
            Map<Character, Integer> needs = new HashMap<>();
            Map<Character, Integer> windows = new HashMap<>();
            for (char c : p.toCharArray()) {
                needs.merge(c, 1, Integer::sum);
            }
            int match = 0;
            while (right < s.length()) {

                char c1 = s.charAt(right);
                if (needs.containsKey(c1)) {
                    windows.merge(c1, 1, Integer::sum);
                    if (windows.get(c1).intValue() == needs.get(c1)) {
                        match++;
                    }
                }
                right++;
                while (match == needs.size()) {
                    if (right - left == p.length()) {
                        list.add(left);
                    }
                    char c2 = s.charAt(left);
                    if (needs.containsKey(c2)) {
                        windows.merge(c2, -1, Integer::sum);
                        if (windows.get(c2) < needs.get(c2)) {
                            match--;
                        }
                    }
                    left++;
                }
            }
            return list;
        }
    }
}

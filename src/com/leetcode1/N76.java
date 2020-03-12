package com.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class N76 {

    public static void main(String[] args) {
        String x = new Solution().minWindow("ADOBECODEBANCBA", "ABC");
        System.out.println(x);
    }

    static class Solution {
        public String minWindow(String s, String t) {
            int start = 0;
            int minLen = Integer.MAX_VALUE;

            int left = 0;
            int right = 0;
            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> needs = new HashMap<>();

            for (char c : t.toCharArray()) {
                needs.merge(c, 1, Integer::sum);
            }
            int match = 0;
            while (right < s.length()) {
                char c1 = s.charAt(right);
                if (needs.containsKey(c1)) {
                    window.merge(c1, 1, Integer::sum);
                    if (window.get(c1).intValue() == needs.get(c1)) {
                        match++;
                    }
                }
                right++;
                while (match == needs.size()) {
                    if (right - left < minLen) {
                        start = left;
                        minLen = right - left;
                    }
                    char c2 = s.charAt(left);
                    if (needs.containsKey(c2)) {
                        window.merge(c2, -1, Integer::sum);
                        if (window.get(c2) < needs.get(c2)) {
                            match--;
                        }
                    }
                    left++;
                }
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        }
    }
}

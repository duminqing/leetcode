package com.leetcode3;

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
        String s = new Solution().minWindow("ADOBECODEBANC", "ABC");

        System.out.println(s);
    }

    static class Solution {
        public String minWindow(String s, String t) {
            int left = 0, right = 0;
            int start = 0, len = Integer.MAX_VALUE;
            Map<Character, Integer> needs = new HashMap<>();
            Map<Character, Integer> windows = new HashMap<>();
            for (char c : t.toCharArray()) {
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
                    start = left;
                    len = right - left;
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
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
}

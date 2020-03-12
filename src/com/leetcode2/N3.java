package com.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 通过次数381,642提交
 */
public class N3 {
    public static void main(String[] args) {
        int x = new Solution().lengthOfLongestSubstring("pwwkew");
        System.out.println(x);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (right < s.length()) {
                char c1 = s.charAt(right);
                map.merge(c1, 1, Integer::sum);
                right++;
                while (map.get(c1) > 1) {
                    char c2 = s.charAt(left);
                    map.merge(c2, -1, Integer::sum);
                    left++;
                }
                max = Math.max(max, right - left);
            }
            return max;
        }
    }
}

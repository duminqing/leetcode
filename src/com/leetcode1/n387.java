package com.leetcode1;

import java.util.*;

public class n387 {
    static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Long> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.merge(c, 1L, Long::sum);
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }


    }

    public static void main(String[] args) {
        int x = new Solution().firstUniqChar("loveleetcode");
        System.out.println(x);
    }
}

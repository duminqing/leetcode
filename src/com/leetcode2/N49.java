package com.leetcode2;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class N49 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] strArray = str.toCharArray();
                Arrays.sort(strArray);
                String key = new String(strArray);
                map.merge(key, map.getOrDefault(key, new ArrayList<String>() {
                    {
                        add(str);
                    }
                }), (a, b) -> {
                    a.add(str);
                    return a;
                });

            }
            System.out.println(map.values());
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        List<List<String>> list = new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

}

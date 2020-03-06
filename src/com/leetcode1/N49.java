package com.leetcode1;

import java.util.*;

public class N49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s0 = new String(chars);
            if (map.containsKey(s0)) {
                map.get(s0).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s0, list);

            }
        }

        return new ArrayList<>(map.values());
    }
}

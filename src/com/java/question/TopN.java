package com.java.question;

import java.util.*;

public class TopN {
    public static void main(String[] args) {
        String a = "package com.leetcode.dynamicprogramming;";
        topN(a, 5);
    }

    /**
     * 查找source中出现次数最多的前N个字符
     */
    private static void topN(String source, int n) {
        char[] sourceArray = source.toCharArray();
        // 统计
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : sourceArray) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        // 排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        // 输出前N不考虑有相等的
        list.stream().limit(n).forEach((en) -> System.out.println(en.getKey() + " = " + en.getValue()));
    }

}

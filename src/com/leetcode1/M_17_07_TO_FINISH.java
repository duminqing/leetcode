package com.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.07. 婴儿名字
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 * <p>
 * 在结果列表中，选择字典序最小的名字作为真实名字。
 * <p>
 * 示例：
 * <p>
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 * 提示：
 * <p>
 * names.length <= 100000
 */
public class M_17_07_TO_FINISH {

    public static void main(String[] args) {
        new Solution().trulyMostPopular(new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"},
                new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"});

    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int n) {
            if (parent[n] != n) {
                parent[n] = find(parent[n]);
            }
            return parent[n];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    static class Solution {
        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            String regex = "\\W";
            Map<String, Integer> nameCountMap = new HashMap<>();
            Map<String, Integer> nameIdMap = new HashMap<>();
            Map<Integer, String> idNameMap = new HashMap<>();
            for (int i = 0; i < names.length; i++) {
                String[] nameCountArray = names[i].split(regex);
                String name = nameCountArray[0];
                nameIdMap.put(name, i);
                idNameMap.put(i, name);
                nameCountMap.put(name, Integer.valueOf(nameCountArray[1]));
            }
            System.out.println(nameCountMap);
            System.out.println(nameIdMap);

            UnionFind unionFind = new UnionFind(names.length);

            for (String s : synonyms) {
                String[] synonymsArray = s.split("\\W");
                String n1 = synonymsArray[1];
                String n2 = synonymsArray[2];

                System.out.println("n1,n2 " + n1 + " " + n2);
                Integer x = nameIdMap.get(n1);
                Integer y = nameIdMap.get(n2);
                System.out.println(" x,y = " + x + "," + y);
                if (x != null && y != null) {
                    unionFind.union(x, y);
                }
            }

            for (int i = 0; i < unionFind.parent.length; i++) {
                if (unionFind.parent[i] != i) {
                    unionFind.union(i, unionFind.parent[i]);
                }
            }

            Map<Integer, Integer> IdCountMap = new HashMap<>();
            for (int i = 0; i < unionFind.parent.length; i++) {
                IdCountMap.merge(unionFind.parent[i], nameCountMap.get(idNameMap.get(i)), Integer::sum);
            }

            for (int i = 0; i < unionFind.parent.length; i++) {
                System.out.println(i + " " + unionFind.parent[i]);
            }
            return null;
        }
    }
}

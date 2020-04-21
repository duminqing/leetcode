package com.leetcode1;

import java.util.*;

/**
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 * <p>
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 * <p>
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 * <p>
 * 例子 1:
 * <p>
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * 第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
 * 我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
 * <p>
 * 注意：
 * <p>
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 */
public class N721 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> list2 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> list3 = Arrays.asList("Mary", "mary@mail.com");
        List<String> list4 = Arrays.asList("John", "johnnybravo@mail.com");
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(new Solution().accountsMerge(list));

    }

    static class Solution {
        class DSU {

            int[] parent;

            public DSU() {
                parent = new int[10001];
                for (int i = 0; i <= 10000; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y) {
                parent[find(x)] = find(y);
            }
        }

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> emailName = new HashMap<>();
            Map<String, Integer> emailId = new HashMap<>();
            int id = 0;
            DSU dsu = new DSU();
            for (List<String> account : accounts) {
                String name = null;
                for (String email : account) {
                    if (name == null) {
                        name = email;
                        continue;
                    }
                    emailName.put(email, name);
                    if (!emailId.containsKey(email)) {
                        emailId.put(email, id++);
                    }
                    dsu.union(emailId.get(account.get(1)), emailId.get(email));
                }
            }

            Map<Integer, List<String>> ans = new HashMap<>();
            for (String email : emailName.keySet()) {
                int index = dsu.find(emailId.get(email));
                ans.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
            }
            for (List<String> component : ans.values()) {
                Collections.sort(component);
                component.add(0, emailName.get(component.get(0)));
            }
            return new ArrayList<>(ans.values());
        }
    }
}

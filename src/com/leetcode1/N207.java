package com.leetcode1;

import java.util.*;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 */
public class N207 {
    public static void main(String[] args) {
        boolean x = new Solution().canFinish(2, new int[][]{{0, 1}});
        System.out.println(x);
    }

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegree = new int[numCourses];
            List<List<Integer>> linjie = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                linjie.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                indegree[prerequisite[0]]++;
                linjie.get(prerequisite[1]).add(prerequisite[0]);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }

            }

            while (!queue.isEmpty()) {
                int pre = queue.poll();
                numCourses--;
                for (int cur : linjie.get(pre)) {
                    if (--indegree[cur] == 0) {
                        queue.add(cur);
                    }
                }
            }
            return numCourses == 0;
        }
    }
}

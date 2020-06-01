package com.leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 621. 任务调度器
 * <p>
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *  
 * <p>
 * 提示：
 * <p>
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N621 {

    public static void main(String[] args) {
        int x = new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        System.out.println(x);
    }

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c : tasks) {
                map[c - 'A']++;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : map) {
                if (i > 0) {
                    queue.add(i);
                }
            }
            int time = 0;
            while (!queue.isEmpty()) {

                List<Integer> tmp = new ArrayList<>();
                int i = 0;
                while (i <= n) {
                    if (!queue.isEmpty()) {
                        if (queue.peek() > 1) {
                            tmp.add(queue.poll() - 1);
                        } else {
                            queue.poll();
                        }
                    }
                    time++;
                    if (queue.isEmpty() && tmp.isEmpty()) {
                        break;
                    }
                    i++;
                }
                queue.addAll(tmp);
            }
            return time;
        }
    }
}

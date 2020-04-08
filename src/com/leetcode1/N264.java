package com.leetcode1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 */
public class N264 {
    public static void main(String[] args) {
        long x = new Solution().nthUglyNumber(1407);
        //536870912
        System.out.println(x);
    }

    /**
     * 使用动态规划三指针
     */
    static class Solution {
        public int nthUglyNumber(int n) {

            int[] nums = new int[n];
            nums[0] = 1;
            int ugly;
            int i2 = 0;
            int i3 = 0;
            int i5 = 0;
            for (int i = 1; i < n; i++) {
                ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
                nums[i] = ugly;
                if (ugly == nums[i2] * 2) {
                    i2++;
                }
                if (ugly == nums[i3] * 3) {
                    i3++;
                }
                if (ugly == nums[i5] * 5) {
                    i5++;
                }
            }
            return nums[n - 1];
        }
    }

    /**
     * 使用堆处理
     */
    static class Solution2 {
        public int nthUglyNumber(int n) {
            long[] nth = new long[n];
            PriorityQueue<Long> heap = new PriorityQueue<>(Comparator.comparingLong(n1 -> n1));
            heap.add(1L);
            int i = 0;
            while (i < n) {
                long min = heap.poll();
                nth[i++] = min;
                if (!heap.contains(min * 2)) {
                    heap.add(min * 2);
                }
                if (!heap.contains(min * 3)) {
                    heap.add(min * 3);
                }
                if (!heap.contains(min * 5)) {
                    heap.add(min * 5);
                }
            }
            return (int) nth[n - 1];
        }
    }
}

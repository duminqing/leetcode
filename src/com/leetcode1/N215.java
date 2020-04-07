package com.leetcode1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class N215 {

    public static void main(String[] args) {
        new Solution().findKthLargest(new int[]{10, 9, 3, 4, 2, 1, 7, 16, 9, 10}, 8);
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
            for (int n : nums) {
                heap.add(n);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            return heap.poll();
        }
    }
}

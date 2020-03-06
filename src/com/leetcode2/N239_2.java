package com.leetcode2;

import java.util.ArrayDeque;

public class N239_2 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] max = new int[nums.length - k + 1];
        int j = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - k == deque.getFirst()) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                max[j++] = nums[deque.getFirst()];
            }
        }
        return max;

    }
}

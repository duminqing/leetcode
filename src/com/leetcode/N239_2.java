package com.leetcode;

import java.util.ArrayDeque;

public class N239_2 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        int j = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.getLast() <= nums[i]) {
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

package com.leetcode2;

public class N45 {
    class Solution {
        public int jump(int[] nums) {
            int step = 0;
            int further = 0;
            int end = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                further = Math.max(further, i + nums[i]);
                if (i == end) {
                    end = further;
                    step++;
                }
            }
            return step;
        }
    }
}

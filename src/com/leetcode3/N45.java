package com.leetcode3;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class N45 {
    public static void main(String[] args) {
        int x = new Solution().jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(x);
    }

    static class Solution {
        public int jump(int[] nums) {
            int step = 0;
            int further = 0;
            int end = 0;
            for (int i = 0; i < nums.length-1; i++) {
                further = Math.max(further, nums[i] + i);
                if (i == end) {
                    end = further;
                    step++;
                }
            }
            return step;
        }
    }
}

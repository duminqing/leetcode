package com.leetcode1;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class N55 {
    /**
     * 最佳算法：贪心算法
     */
    static class Solution0 {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i - 1] > i) {
                    lastPos = i;
                }
            }

            return lastPos == 0;
        }
    }

    /**
     * 回溯
     */
    static class Solution1 {
        public boolean canJump(int[] nums) {
            return canJumpFromPosition(0, nums);
        }

        private boolean canJumpFromPosition(int position, int[] nums) {
            if (position > nums.length - 1) {
                return true;
            }
            int furthestJump = Math.min(position + nums[position], nums.length);
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 动态规划
     */
    static class Solution2 {
        public boolean canJump(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length - 1; i++) {
                if (i == 0) {
                    dp[i] = nums[0];
                } else {
                    dp[i] = Math.max(dp[i - 1], nums[i] + i);
                }
                if (dp[i] < i + 1) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 动态规划 优化内存
     */
    static class Solution3 {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            int last = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                if (last < i) { //如果上一次跳不到该位置则失败
                    return false;
                }
                last = Math.max(last, nums[i] + i);
            }
            return last >= nums.length - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().canJump(new int[]{2, 3, 1, 1, 4}));

        System.out.println(new Solution2().canJump(new int[]{3, 2, 1, 0, 4}));

        System.out.println(new Solution2().canJump(new int[]{0, 3, 2}));
        System.out.println(new Solution2().canJump(new int[]{1, 0, 1, 0}));
        System.out.println(new Solution2().canJump(new int[]{1, 2}));
        System.out.println(new Solution2().canJump(new int[]{0}));
        System.out.println(new Solution2().canJump(new int[]{0, 1}));
    }
}

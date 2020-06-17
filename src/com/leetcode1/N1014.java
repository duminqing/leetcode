package com.leetcode1;

/**
 * 1014. 最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class N1014 {
    public static void main(String[] args) {
        int x = new Solution().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6});
        System.out.println(x);
    }

    static class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            // a[i]+i+ a[j]-j
            int max = 0;
            int maxi = A[0] + 0;
            for (int j = 1; j < A.length; j++) {
                max = Math.max(max, maxi + A[j] - j);
                maxi = Math.max(maxi, A[j] + j);
            }
            return max;
        }
    }
}

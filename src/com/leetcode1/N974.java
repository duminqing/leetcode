package com.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 */
public class N974 {
    public static void main(String[] args) {
        new Solution().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
    }

    static class Solution {
        public int subarraysDivByK(int[] A, int K) {
            Map<Integer, Integer> record = new HashMap<>();
            record.put(0, 1);
            int sum = 0, ans = 0;

            for (int a : A) {

                sum += a;
                int modules = (sum % K + K) % K;
                int same = record.getOrDefault(modules, 0);
                ans += same;
                record.put(modules, same + 1);
                System.out.println("a = " + a + "; ans = " + ans + "; record = " + record);
            }
            return ans;
        }
    }
}

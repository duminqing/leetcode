package com.leetcode1;

import java.util.PriorityQueue;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class M_17_14 {
    public static void main(String[] args) {
        int[] a = new Solution().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        for (int o : a) {
            System.out.println(o);
        }
    }

    static class Solution {
        public int[] smallestK(int[] arr, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n2 - n1);
            for (int n : arr) {
                heap.add(n);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            int[] small = new int[k];
            for (int i = 0; i < k; i++) {
                small[i] = heap.poll();
            }
            return small;
        }
    }
}

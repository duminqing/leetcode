package com.leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class N350 {
    public static void main(String[] args) {
        int[] x = new Solution().intersect(new int[]{4, 9, 5, 4, 4}, new int[]{9, 4, 9, 8, 4, 6});
        for (int a : x) {
            System.out.print(a);

        }
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int num : nums1) {
                map.merge(num, 1, Integer::sum);
            }
            for (int num : nums2) {
                if (map.containsKey(num)) {
                    if (map.get(num) > 1) {
                        map.merge(num, -1, Integer::sum);
                    } else {
                        map.remove(num);
                    }
                    list.add(num);
                }
            }

            return list.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}

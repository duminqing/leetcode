package com.leetcode1;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class N33 {
    static class Solution {
        public int search(int[] nums, int target) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo == hi && nums[lo] == target ? lo : -1;
        }
    }


    static class Solution2 {
        public int search(int[] nums, int target) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[lo] <= nums[mid]) {
                    if (target >= nums[lo] && target < nums[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    if (target <= nums[hi] && target > nums[mid]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0);
    }
}

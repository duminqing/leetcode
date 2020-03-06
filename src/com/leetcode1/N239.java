package com.leetcode1;

import java.util.ArrayDeque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N239 {


    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;
        if (length * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] output = new int[length - k + 1];
        int j = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            // 从后往前移除所有小于当前的值
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 把当前元素插入
            deque.addLast(i);
            // 第一个元素是否过期
            if (deque.getFirst() == i - k) {
                deque.pollFirst();
            }
            // 满足K长度则输出首个元素
            if (i >= k - 1) {
                output[j++] = nums[deque.getFirst()];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        N239 n2391 = new N239();
        int[] nums = {7,2,4};
        for (int i : n2391.maxSlidingWindow(nums, 2)) {
            System.out.print(i);
        }
    }
}

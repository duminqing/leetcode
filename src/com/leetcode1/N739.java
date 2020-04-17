package com.leetcode1;

import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * @author Administrator
 */
public class N739 {
    public static void main(String[] args) {
        int[] x = new Solution().dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70});
        for (int k : x) {
            System.out.print(k + " ");
        }

    }

    /**
     * 使用栈
     */
    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] d = new int[T.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = T.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                    stack.pop();
                }
                d[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return d;
        }
    }
}

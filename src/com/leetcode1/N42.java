package com.leetcode1;

import java.util.Stack;

public class N42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                area += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - h);
            }
            stack.push(i);
        }
        return area;
    }


//    {
//        int sum = 0;
//        Stack<Integer> stack = new Stack<>();
//
//        for (int current = 0; current < height.length; current++) {
//            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
//            while (!stack.empty() && height[current] > height[stack.peek()]) {
//                int h = height[stack.pop()]; //出栈并且获取其高度
//                if (stack.empty()) { // 栈空就出去
//                    break;
//                }
//                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
//                int min = Math.min(height[stack.peek()], height[current]);
//                sum += distance * (min - h);
//            }
//            stack.push(current); //当前指向的墙入栈
//        }
//        return sum;
//    }


}


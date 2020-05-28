package com.leetcode1;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class N394 {
    public static void main(String[] args) {
        String a = new Solution().decodeString("2[abc]3[cd]ef");
        System.out.println(a);
    }

    static class Solution {
        public String decodeString(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c != ']') {
                    stack.push(c);
                } else {
                    StringBuilder word = new StringBuilder();
                    while (stack.peek() != '[') {
                        word.insert(0, stack.pop());
                    }
                    // 去掉[
                    stack.pop();

                    StringBuilder countString = new StringBuilder();
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                        countString.insert(0, stack.pop());
                    }
                    int count = Integer.parseInt(countString.toString());
                    while (count-- > 0) {
                        for (int j = 0; j < word.length(); j++) {
                            stack.push(word.charAt(j));
                        }
                    }
                }
            }
            StringBuilder word = new StringBuilder();
            while (!stack.isEmpty()) {
                word.insert(0, stack.pop());
            }
            return word.toString();
        }
    }
}

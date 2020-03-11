package com.leetcode1;

/**
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 */
public class N917 {
    static class Solution {

        public String reverseOnlyLetters(String S) {
            char[] chars = S.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                while (!Character.isLetter(chars[i]) && i < j) {
                    i++;
                }
                while (!Character.isLetter(chars[j]) && i < j) {
                    j--;
                }
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}

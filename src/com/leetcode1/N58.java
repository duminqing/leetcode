package com.leetcode1;

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class N58 {
    static class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null) {
                return 0;
            }
            char[] chars = s.toCharArray();
            boolean begin = false;
            int count = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (begin) {
                    if (chars[i] == ' ') {
                        break;
                    } else {
                        count++;
                    }
                } else {
                    if (chars[i] != ' ') {
                        begin = true;
                        count++;
                    }
                }


            }
           System.out.println(count);
            return count;
        }
    }

    public static void main(String[] args) {
        new Solution().lengthOfLastWord(" aaa a  aa   ");
    }
}

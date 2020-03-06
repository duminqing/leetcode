package com.leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N22 {
    /**
     * 22. 括号生成
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if (n == 0) {
            return Collections.emptyList();
        }
        dbf(n, "", 0, 0, resultList);
        return resultList;
    }

    private void dbf(int n, String result, int left, int right, List<String> resultList) {
        if (right > left) {
            return;
        }
        if (left == n && right == n) {
            resultList.add(result);
            return;
        }
        if (left < n) {
            dbf(n, result + "(", left + 1, right, resultList);
        }
        if (right < n) {
            dbf(n, result + ")", left, right + 1, resultList);
        }
    }
}

package com.test;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static List<Integer> sSorted = new LinkedList<>();

    public static void addElement(int e) {
        // TODO
        if (sSorted.isEmpty()) {
            sSorted.add(e);
            return;
        }

        sSorted.add(index(e), e);
    }

    static int index(int e) {
        if (sSorted.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < sSorted.size(); i++) {
            if (sSorted.get(i) > e) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        addElement(3);
        addElement(2);
        addElement(1);
        addElement(2);
        System.out.println(sSorted);
    }
}

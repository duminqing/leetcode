package com.sort1;

import com.sort.Sort;

public class InsertSort extends Sort {

    @Override
    public void sort(int[] arr) {
        // 7 4 5 1 3 12 6
        for (int i = 1; i < arr.length ; i++) {
            int tmp = arr[i];
            int pre = i - 1;
            while (pre >= 0 && arr[pre] > tmp) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 6, 5, 4, 9, 11, 2};
        new InsertSort().sort(arr);
        print(arr);
    }
}

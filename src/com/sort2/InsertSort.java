package com.sort2;

import com.sort.Sort;

public class InsertSort extends Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            int pre = i - 1;
            int tmp = arr[i];

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

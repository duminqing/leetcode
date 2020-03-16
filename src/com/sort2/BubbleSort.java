package com.sort2;

import com.sort.Sort;

public class BubbleSort extends Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 6, 5, 4, 9, 11};
        new BubbleSort().sort(arr);
        print(arr);
    }
}

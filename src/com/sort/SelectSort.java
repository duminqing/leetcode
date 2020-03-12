package com.sort;

public class SelectSort extends Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 6, 5, 4, 9, 11, 2};
        new SelectSort().sort(arr);
        print(arr);
    }

}

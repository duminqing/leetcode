package com.sort;

public class BubbleSort extends Sort {

    /**
     * 因为冒泡排序在排序时大的会往后挪，后一个肯定会大于前一个，
     * 第一个for记录第几次排序，
     * 第二个for控制自排序需要的个数
     */
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
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

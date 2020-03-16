package com.sort2;

import com.sort.Sort;

public class HeapSort extends Sort {
    @Override
    public void sort(int[] arr) {
        for (int j = arr.length / 2 - 1; j >= 0; j--) {
            heapSort(arr, j, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapSort(arr, 0, i);
        }
    }

    private void heapSort(int[] arr, int i, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int max = i;
        if (left < len && arr[left] > arr[max]) {
            max = left;
        }
        if (right < len && arr[right] > arr[max]) {
            max = right;
        }
        if (i != max) {
            swap(arr, max, i);
            heapSort(arr, max, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, -1};
        new HeapSort().sort(arr);
        print(arr);
    }
}

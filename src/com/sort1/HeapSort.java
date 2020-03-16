package com.sort1;

import com.sort.Sort;

public class HeapSort extends Sort {
    @Override
    public void sort(int[] array) {
        if (array.length == 0) {
            return;
        }

        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            swap(array, i, 0);
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, largest, i);
            heapify(array, length, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, -1};
        new HeapSort().sort(arr);
        print(arr);
    }
}

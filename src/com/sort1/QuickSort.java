package com.sort1;

import com.sort.Sort;

public class QuickSort extends Sort {
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private int getIndex(int[] arr, int low, int high) {
        int tmp = arr[high];
        while (low < high) {
            while (low < high && arr[low] < tmp) {
                low++;
            }
            arr[high] = arr[low];
            while (low < high && arr[high] > tmp) {
                high--;
            }
            arr[low] = arr[high];
        }
        arr[high] = tmp;
        return high;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 6, 5, 4, 9, 11};
        new QuickSort().sort(arr);
        print(arr);
    }
}

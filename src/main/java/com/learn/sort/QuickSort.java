package com.learn.sort;

import com.learn.util.Common;

/**
 * Time Complexity: Worst: O(n^2), Average: O(nlog(n)), Best: O(nlog(n))
 * Auxiliary Space: O(1)
 * Algorithmic Paradigm: Divide and Conquer
 * Sorting In Place: Yes
 * Stable: No
 */
public class QuickSort {

    public int partition(int[] arr, int l, int r) {
        int i = l - 1;
        int j = r + 1;

        int pivot = arr[l];

        while (true) {
            do {
                i++;
            }
            while (i <= r && arr[i] < pivot);

            do {
                j--;
            }
            while (j >= l && arr[j] > pivot);

            if (i >= j) {
                return i;
            }

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition(arr, l, r);
        quickSort(arr, l, p -1);
        quickSort(arr, p + 1, r);
    }

    public static void main(String[] args) {
        //int[] input = {64, 34, 25, 12, 22, 11, 90};
        //int[] input = {2,2,2,2,2,2};
        int[] input = {2, 4, 1, 3, 9, 0, 6};
        QuickSort ob = new QuickSort();
        ob.quickSort(input, 0, input.length - 1);
        Common.printArray(input);
    }
}

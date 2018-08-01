package com.learn.review.sort;

import com.learn.util.Common;

/**
 * Time Complexity: O(nlog(n))
 * Auxiliary Space: O(n)
 * Algorithmic Paradigm: DDivide and Conquer
 * Sorting In Place: No in a typical implementation
 * Stable: Yes
 */
public class MergeSort {

    static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l == r)
            return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int k = 0;

        int[] out = new int[r - l + 1];
        while (i <= m & j <= r) {
            if (arr[i] <= arr[j])
                out[k++] = arr[i++];
            else
                out[k++] = arr[j++];
        }
        while (i <= m) {
            out[k++] = arr[i++];
        }
        while (j <= r) {
            out[k++] = arr[j++];
        }
        for (int t = 0; t < r - l + 1; t++)
            arr[l + t] = out[t];
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 9, 0, 6};
        sort(arr);
        Common.printArray(arr);
    }
}

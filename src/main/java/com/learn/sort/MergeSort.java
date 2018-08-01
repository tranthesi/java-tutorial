package com.learn.sort;

import com.learn.util.Common;
import java.util.Arrays;

/**
 * Time Complexity: O(nlog(n))
 * Auxiliary Space: O(n)
 * Algorithmic Paradigm: Divide and Conquer
 * Sorting In Place: No
 * Stable: Yes
 */
public class MergeSort {

    public void mergeSort(int[] arr, int l, int r) {
        if (l == r)
            return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public void merge(int[] arr, int l, int m, int r) {
        int[] arr1 = Arrays.copyOfRange(arr, l, m + 1);
        int[] arr2 = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0;
        int j = 0;
        int k = l;

        while (i < arr1.length & j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        MergeSort ob = new MergeSort();
        ob.mergeSort(input, 0, input.length - 1);
        Common.printArray(input);
    }
}

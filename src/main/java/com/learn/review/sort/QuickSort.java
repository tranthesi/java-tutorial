package com.learn.review.sort;

import com.learn.util.Common;

/**
 * Time Complexity: Worst: O(n^2), Average: O(nlog(n)), Best: O(nlog(n))
 * Auxiliary Space: O(1)
 * Algorithmic Paradigm: Divide and Conquer
 * Sorting In Place: Yes
 * Stable: No
 */

public class QuickSort {

    static void sort(int[] arr) {
        quickSort(arr, 0, arr.length -1);
    }

    static void quickSort(int[] arr, int l, int r) {
        if(l>=r)
            return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p );
        quickSort(arr, p + 1, r);
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[(l+r)/2];
        int i = l - 1;
        int j = r + 1;

        while(true) {
            do {
                i++;
            } while(arr[i] < pivot);

            do {
                j--;
            } while(arr[j] > pivot);

            if(i>=j)
                return j;
            //swap element
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 9, 0, 6};
        sort(arr);
        Common.printArray(arr);
    }

}

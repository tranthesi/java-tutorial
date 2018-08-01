package com.learn.review.sort;

import com.learn.util.Common;

/**
 * Time Complexity: Worst: O(n^2), Average: O(n^2), Best: O(n)
 * Auxiliary Space: O(1)
 * Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order.
 * And it takes minimum time (Order of n) when elements are already sorted
 * Algorithmic Paradigm: Incremental Approach
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class InsertionSort {

    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int ele = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > ele) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[++j] = ele;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 9, 0, 6};
        sort(arr);
        Common.printArray(arr);
    }
}

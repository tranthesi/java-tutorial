package com.learn.review.sort;

import com.learn.util.Common;

/**
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1)
 * Algorithmic Paradigm: Incremental Approach
 * Sorting In Place: Yes
 * Stable: Default is No
 */
public class SelectionSort {

    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int pMin = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[pMin])
                    pMin = j;
            }
            if (pMin != i) {
                int tmp = arr[i];
                arr[i] = arr[pMin];
                arr[pMin] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 9, 0, 6};
        sort(arr);
        Common.printArray(arr);
    }

}

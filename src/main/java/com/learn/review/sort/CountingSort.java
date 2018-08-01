package com.learn.review.sort;

import com.learn.util.Common;

/**
 * Time Complexity: O(n+k)
 * Auxiliary Space: O(n+k)
 * Sorting In Place: Yes
 * Stable: No
 */
public class CountingSort {

    static void sort(int[] arr) {
        int n = arr.length;
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int[] count = new int[max + 1];
        for (int a : arr) {
            count[a]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[--count[arr[i]]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 9, 0, 6};
        sort(arr);
        Common.printArray(arr);
    }
}

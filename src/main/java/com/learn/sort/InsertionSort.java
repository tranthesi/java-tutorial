package com.learn.sort;

import com.learn.util.Common;

/**
 * Time Complexity: Worst: O(n^2), Average: O(n^2), Best: O(n)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int ele = arr[i];
            while (j >= 0 && arr[j] > ele) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = ele;
        }
    }

    public static void main(String[] args) {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        InsertionSort ob = new InsertionSort();
        ob.sort(input);
        Common.printArray(input);
    }
}

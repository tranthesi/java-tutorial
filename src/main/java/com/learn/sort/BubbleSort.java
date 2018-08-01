package com.learn.sort;

import com.learn.util.Common;

/**
 * Time Complexity: Worst: O(n^2), Average: O(n^2), Best: O(n)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class BubbleSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort ob = new BubbleSort();
        ob.sort(input);
        Common.printArray(input);
    }
}

package com.learn.review.sort;

import com.learn.util.Common;

/**
 * Time Complexity: Worst: O(n^2), Average: O(n^2), Best: O(n)
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class BubbleSort {

    static void sort(int[] arr) {
        int n = arr.length;
        boolean swap = false;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //Swap element
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 9, 0, 6};
        sort(arr);
        Common.printArray(arr);
    }
}

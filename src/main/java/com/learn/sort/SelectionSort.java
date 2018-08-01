package com.learn.sort;

import com.learn.util.Common;

/**
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: default is No, https://www.geeksforgeeks.org/stable-selection-sort/
 */
public class SelectionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            //Index of smallest element
            int k = i;
            for(int j=i; j < n; j++) {
                if(arr[j] < arr[k]) {
                    k = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        SelectionSort ob = new SelectionSort();
        ob.sort(input);
        Common.printArray(input);
    }
}

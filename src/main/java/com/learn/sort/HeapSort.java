package com.learn.sort;

import com.learn.util.Common;

/**
 * Time Complexity: O(nlog(n)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Default is No
 */
public class HeapSort {

    public void heapify(int arr[], int n, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;

            heapify(arr, n, largest);
        }
    }




    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = 0; i < n - 1; i++) {
            int tmp = arr[0];
            arr[0] = arr[n - 1 - i];
            arr[n - 1 - i] = tmp;

            heapify(arr, n - 1 - i, 0);
        }
    }

    public static void main(String[] args) {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        //int[] input = {2, 4, 1, 3, 9, 0, 6};
        HeapSort ob = new HeapSort();
        ob.heapSort(input);
        Common.printArray(input);
    }
}

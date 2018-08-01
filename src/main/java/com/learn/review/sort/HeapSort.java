package com.learn.review.sort;

import com.learn.util.Common;

public class HeapSort {

    static void sort(int[] arr) {
        int n = arr.length;
        //build heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            //Swap largest element to the end of heap
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        int largest = i;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (i != largest) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 9, 0, 6};
        sort(arr);
        Common.printArray(arr);
    }

}

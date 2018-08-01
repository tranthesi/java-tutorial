package com.learn.review.sort;

import com.learn.util.Common;

public class RadixSort {

    static void sort(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int base = 10;
        int exp = 1;
        while(exp <= max) {
            countingSort(arr, base, exp);
            exp *= 10;
        }
    }

    static void countingSort(int[] arr, int base, int exp) {
        int n = arr.length;

        int[] count = new int[base];
        for (int a : arr) {
            int e = (a/exp)%base;
            count[e]++;
        }

        for (int i = 1; i < base; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int e = (arr[i]/exp)%base;
            output[--count[e]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 9, 100, 6, 35};
        sort(arr);
        Common.printArray(arr);
    }

}

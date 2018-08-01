package com.learn.sort;

import com.learn.util.Common;

public class RadixSort {

    public void countSort(int[] arr, int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[--count[(arr[i] / exp) % 10]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int exp = 1; exp <= max; exp *= 10) {
            countSort(arr, exp);
        }
    }

    public static void main(String[] args) {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        RadixSort ob = new RadixSort();
        ob.radixSort(input);
        Common.printArray(input);
    }
}

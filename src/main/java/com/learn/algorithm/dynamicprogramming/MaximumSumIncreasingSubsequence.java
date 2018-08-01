package com.learn.algorithm.dynamicprogramming;

public class MaximumSumIncreasingSubsequence {
    static int msis(int[] arr) {
        int n = arr.length;
        int[] F = new int[n];

        F[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && max < F[j] + arr[i])
                    max = F[j] + arr[i];
            }
            F[i] = max;
        }

        /* Pick maximum of all LIS values */
        int max  = 0;
        for (int i = 0; i < n; i++ )
            if ( max < F[i] )
                max = F[i];

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 6};
        System.out.println("Length of longest increase subsequnce: " + msis(arr));
    }
}

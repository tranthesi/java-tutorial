package com.learn.datastructure.array;

// https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        int q = queries.length;
        for (int i = 0; i < q; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int value = queries[i][2];
            arr[start - 1] += value;
            if (end < n)
                arr[end] -= value;
        }

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        long max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] queries = {{1, 5, 3}, {4, 8, 7}, {6, 9, 1}};
        System.out.println(arrayManipulation(10, queries));
    }
}

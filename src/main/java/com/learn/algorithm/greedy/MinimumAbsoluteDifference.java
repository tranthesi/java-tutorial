package com.learn.algorithm.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/
public class MinimumAbsoluteDifference {

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++) {
            int diff = Math.abs(arr[i+1]-arr[i]);
            if(diff < minDiff)
                minDiff = diff;
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = { -59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        System.out.println(minimumAbsoluteDifference(arr));
    }

}

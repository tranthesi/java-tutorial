package com.learn.sort;

import com.learn.util.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public void sort(double[] arr) {
        int n = arr.length;
        List<Double> buckets[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            int bi = (int) (arr[i] * n);
            buckets[bi].add(arr[i]);
        }

        for(int i=0; i<n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        double[] input = {0.1, 0.3, 0.2, 0.9, 0.8, 0.6, 0.6};
        BucketSort ob = new BucketSort();
        ob.sort(input);
        for (int i=0; i<input.length; ++i)
            System.out.print(input[i] + " ");
    }
}

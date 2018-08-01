package com.learn.review.sort;

import com.learn.util.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    static void sort(double[] arr) {
        int m = 10;
        double max = arr[0];
        double min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        double range = (max - min) / m;
        List<Double> buckets[] = new ArrayList[m+1];
        for (int i = 0; i <= m; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            int p = (int) ((arr[i]-min) / range);
            buckets[p].add(arr[i]);
        }

        for (int i = 0; i <= m; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        double[] arr = {2, 4, 1, 3, -9, 100, 6, -35};
        sort(arr);
        Common.printArray(arr);
    }
}

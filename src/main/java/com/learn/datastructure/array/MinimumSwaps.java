package com.learn.datastructure.array;

import java.util.Arrays;

public class MinimumSwaps {

    static int minimumSwapsConsecutive(int[] arr) {
        int i = 0;
        int swap = 0;
        while (i < arr.length - 1) {
            System.out.println("i " + i + " arr[i] " + arr[i]);
            if (arr[i] != i + 1) {
                swap++;
                int tmp = arr[i];
                arr[i] = arr[tmp - 1];
                arr[tmp - 1] = tmp;
            } else {
                i++;
            }
        }
        return swap;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3 ,4 ,1 ,5};
        System.out.println(minimumSwapsConsecutive(arr));
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}

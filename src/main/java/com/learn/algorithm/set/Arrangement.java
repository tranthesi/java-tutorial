package com.learn.algorithm.set;

//k-permutations of n
public class Arrangement {

    static void arrangement(int[] data, int[] result, int k, int c) {
        if (c == k) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
            return;
        }

        int n = data.length;
        int[] newData = new int[n - 1];
        for (int i = 0; i < n; i++) {
            result[c] = data[i];
            for (int j = 0; j < n - 1; j++) {
                if (j < i) {
                    newData[j] = data[j];
                } else {
                    newData[j] = data[j + 1];
                }
            }
            arrangement(newData, result, k, c + 1);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int[] result = new int[data.length];
        arrangement(data, result, 3, 0);
    }
}

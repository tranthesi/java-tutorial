package com.learn.algorithm.set;

public class Permutation {

    public static void permutation(int[] data, int[] result) {
        int k = result.length;
        if (data.length == 0) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
            return;
        }
        int n = data.length;
        int[] newData = new int[n - 1];
        for (int i = 0; i < n; i++) {
            result[k - n] = data[i];
            for (int j = 0; j < n - 1; j++) {
                if (j < i) {
                    newData[j] = data[j];
                } else if (j >= i) {
                    newData[j] = data[j + 1];
                }
            }
            permutation(newData, result);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int[] result = new int[data.length];
        permutation(data, result);
    }
}

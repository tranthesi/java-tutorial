package com.learn.algorithm.set;

public class Combination {

    public static void combination(int[] data, int[] result, int k, int p, int c) {
        int n = data.length;
        if (c == k) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
            return;
        }
        result[c] = data[p];
        combination(data, result, k, p + 1, c + 1);
        if (p < n - (k - c)) {
            combination(data, result, k, p + 1, c);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int[] result = new int[data.length];
        combination(data, result, 3, 0, 0);
    }
}

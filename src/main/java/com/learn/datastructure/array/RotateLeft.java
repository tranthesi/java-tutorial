package com.learn.datastructure.array;

public class RotateLeft {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        //int[] output = rotLeft(input, 7);

        rotLeft2(input, 1, 0);
        for (int x : input) {
            System.out.print(x + " ");
        }
    }

    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        while (d > n)
            d -= n;

        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            int p = i - d;
            if (p < 0) p += n;
            output[p] = a[i];
        }
        return output;
    }

    static void rotLeft2(int[] a, int d, int i) {
        int n = a.length;
        if (i == n)
            return;
        int p = i - d;
        int v = a[i];

        if (p < 0) p += n;
        rotLeft2(a, d, i + 1);
        a[p] = v;
    }
}

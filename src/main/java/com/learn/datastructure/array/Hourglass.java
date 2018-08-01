package com.learn.datastructure.array;

public class Hourglass {
    static int hourglassSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                int hourglass = calHourglass(arr, i, j);
                if (hourglass > max)
                    max = hourglass;
            }
        }
        return max;
    }

    static int calHourglass(int[][] arr, int i, int j) {
        int hourglass = 0;
        for (int k = 0; k < 3; k++) {
            hourglass += arr[i][j + k];
            hourglass += arr[i + 2][j + k];
        }
        hourglass += arr[i + 1][j + 1];
        return hourglass;
    }
}

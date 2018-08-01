package com.learn.algorithm.dynamicprogramming;

public class CoinChange {

    static int countCoin1(int n, int[] S) {
        int m = S.length;

        int[][] f = new int[n + 1][m];

        for (int j = 0; j < m; j++) {
            f[0][j] = 1;
        }

        int x, y;
        for (int j = 0; j < m; j++) {
            for (int i = 1; i <= n; i++) {
                x = i - S[j] >= 0 ? f[i - S[j]][j] : 0;
                y = j >= 1 ? f[i][j - 1] : 0;
                f[i][j] = x + y;
            }
        }
        return f[n][m - 1];
    }

    //Optimize space for v1
    static int countCoin2(int n, int[] S) {
        int m = S.length;
        int[] table = new int[n + 1];

        table[0] = 1;

        for (int j = 0; j < m; j++) {
            for (int i = S[j]; i <= n; i++) {
                table[i] += table[i - S[j]];
            }
        }
        return table[n];
    }

    static int countRec(int S[], int m, int n) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        if (m <= 0 && n >= 1)
            return 0;

        return countRec(S, m - 1, n) + countRec(S, m, n - S[m - 1]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(countRec(arr, 3, 4));
    }
}

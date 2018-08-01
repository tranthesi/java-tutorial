package com.learn.algorithm.dynamicprogramming;

public class SubsetSum {

    static boolean isSubsetSum(int n, int[] s) {
        int m = s.length;
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            f[0][j] = true;
        }

        boolean x, y;
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                f[i][j] = f[i][j-1];
                if (i >= s[j-1])
                    f[i][j] = f[i][j] || f[i - s[j-1]][j-1];
            }
        }
        return f[n][m];
    }

    static boolean isSubsetSumRec(int set[],
                               int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n-1] > sum)
            return isSubsetSumRec(set, n-1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSumRec(set, n-1, sum) ||
                isSubsetSumRec(set, n-1, sum-set[n-1]);
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        System.out.println(isSubsetSum(sum, set));
    }
}

package com.learn.algorithm.dynamicprogramming;

public class LongestCommonSubsequence {

    static int lcs(char[] X, char[] Y, int n, int m) {
        int[][] F = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(X[i-1] == Y[j-1])
                    F[i][j] = F[i-1][j-1] + 1;
                else {
                    int f1 = F[i][j-1];
                    int f2 = F[i-1][j];
                    F[i][j] = Math.max(f1, f2);
                }
            }
        }

        int i=n, j=m;
        String result = "";
        while (i>0 && j>0) {
            if(X[i-1] == Y[j-1]) {
                result += X[i-1];
                i--;
                j--;
            } else {
                if(F[i][j] == F[i][j-1]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        System.out.println("lcs is: " + new StringBuilder(result).reverse());
        return F[n][m];
    }

    static int lcsRec( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcsRec(X, Y, m-1, n-1);
        else
            return Math.max(lcsRec(X, Y, m, n-1), lcsRec(X, Y, m-1, n));
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " + lcs( X, Y, m, n ) );
    }
}

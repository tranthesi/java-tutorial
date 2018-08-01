package com.learn.algorithm.dynamicprogramming;

//use LongestCommonSubsequence
public class LongestRepeatedSubsequence {

    static int lrs(char[] X, int n) {
        int[][] F = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(X[i-1] == X[j-1] && i != j)
                    F[i][j] = F[i-1][j-1] + 1;
                else {
                    int f1 = F[i][j-1];
                    int f2 = F[i-1][j];
                    F[i][j] = Math.max(f1, f2);
                }
            }
        }

        int i=n, j=n;
        String result = "";
        while (i>0 && j>0) {
            if(X[i-1] == X[j-1] && i != j) {
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
        System.out.println("lrs is: " + new StringBuilder(result).reverse());

        return F[n][n];
    }

    public static void main(String[] args) {
        String s1 = "AABEBCDD";

        char[] X=s1.toCharArray();
        int n = X.length;

        System.out.println("Length of LRS is" + " " + lrs( X, n ) );
    }
}

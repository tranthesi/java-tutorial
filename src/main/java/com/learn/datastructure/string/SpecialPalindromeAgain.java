package com.learn.datastructure.string;

import java.util.*;

//https://www.hackerrank.com/challenges/special-palindrome-again
public class SpecialPalindromeAgain {
    static class Point {
        public char key;
        public long count;

        public Point(char x, long y) {
            key = x;
            count = y;
        }
    }
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        char[] data = (s + " ").toCharArray();
        List<Point> lst = new ArrayList();
        long sum = 0;

        char key = data[0];
        long count = 0;
        for(int i=0; i<=n; i++) {
            if(data[i] == key) {
                count ++;
            } else {
                Point p = new Point(key, count);
                lst.add(p);
                key = data[i];
                count = 1;
            }
        }
        for(int i=0; i<lst.size(); i++) {
            long c = lst.get(i).count;
            sum += c * (c+1) /2;
        }

        for(int i =1; i < lst.size() -1; i++) {
            if(lst.get(i).count == 1 && lst.get(i-1).key == lst.get(i+1).key) {
                sum += Math.min(lst.get(i-1).count, lst.get(i+1).count);
            }
        }
        return sum;
    }
    static long substrCount_old(int n, String s) {
        char[] data = s.toCharArray();
        int count = 0;
        for(int i=0; i<n; i++) {
            count ++;

            int j = i -1;
            while( j >= 0 && data[j] == data[i]) {
                if( (i-j) % 2 == 1)
                    count ++;
                j--;
            }

            j = 1;
            while( i-j>=0 && i+j<=n-1 && data[i-j]==data[i+j]) {
                if(j > 1 && data[i-1]!=data[i-j]) {
                    break;
                }
                count ++;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(substrCount(7, "abcbaba"));
    }
}

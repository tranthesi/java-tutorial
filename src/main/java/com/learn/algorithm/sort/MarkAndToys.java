package com.learn.algorithm.sort;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/mark-and-toys/

public class MarkAndToys {
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;
        int total = 0;
        for(int i=0; i<k; i++) {
            if(total + prices[i] <= k) {
                total += prices[i];
                count ++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] prices = {1, 12, 5, 111, 200, 1000, 10};
        System.out.println(maximumToys(prices, 50));
    }
}

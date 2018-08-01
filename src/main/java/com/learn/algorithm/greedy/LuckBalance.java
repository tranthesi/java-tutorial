package com.learn.algorithm.greedy;

import java.util.*;

// https://www.hackerrank.com/challenges/luck-balance
public class LuckBalance {
    static int luckBalance(int k, int[][] contests) {
        int total = 0;
        List<Integer> impContests = new ArrayList();
        for(int i = 0; i<contests.length; i++) {
            if(contests[i][1] == 0)
                total += contests[i][0];
            else
                impContests.add(contests[i][0]);
        }
        Collections.sort(impContests);
        for(int i=0; i<impContests.size(); i++) {
            if(i >= impContests.size() - k)
                total += impContests.get(i);
            else
                total -= impContests.get(i);
        }
        return total;
    }

    public static void main(String[] args) {

    }
}

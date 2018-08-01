package com.learn.datastructure.hash;

import java.util.*;

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        char[] arr = s.toCharArray();
        Map<String, Integer> map = new HashMap();
        calAnagrams(arr, 1, map);
        int count = 0;
        for (int value : map.values()) {
            if (value >= 2)
                count += combination(value, 2);
        }
        return count;
    }

    static void calAnagrams(char[] arr, int l, Map<String, Integer> map) {
        int n = arr.length;
        if (l > n)
            return;
        for (int i = 0; i <= n - l; i++) {
            char[] data = Arrays.copyOfRange(arr, i, i + l);
            Arrays.sort(data);
            String key = new String(data);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        calAnagrams(arr, l + 1, map);
    }

    static long combination(int n, int k) {
        if (k < n - k)
            k = n - k;
        long result = 1;
        for (int i = 1; i <= n - k; i++)
            result = result * (i + k) / i;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
    }
}

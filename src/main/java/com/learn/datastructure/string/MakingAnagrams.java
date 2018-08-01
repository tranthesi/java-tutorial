package com.learn.datastructure.string;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {
    public static void main(String[] args) {
        System.out.println(makeAnagram2("cde","abc"));
        Character c = 'a';
        System.out.println(Character.MAX_VALUE + 0);
    }

    static int makeAnagram(String a, String b) {
        int[] aFre = new int[26];
        int[] bFre = new int[26];

        for(char c: a.toCharArray()) {
            aFre[c -'a'] += 1;
        }

        for(char c: b.toCharArray()) {
            bFre[c -'a'] += 1;
        }

        int diff = 0;
        for(int i=0; i<26; i++) {
            diff += Math.abs(aFre[i]-bFre[i]);
        }
        return diff;
    }

    static int makeAnagram2(String a, String b) {
        Map<Character, Integer> count_a = new HashMap<>();
        Map<Character, Integer> count_b = new HashMap<>();
        for(Character c : a.toCharArray()) {
            int count = 1;
            if(count_a.containsKey(c)) {
                count += count_a.get(c);
            }
            count_a.put(c, count);
        }
        for(Character c : b.toCharArray()) {
            int count = 1;
            if(count_b.containsKey(c)) {
                count += count_b.get(c);
            }
            count_b.put(c, count);
        }
        int totalDif = 0;
        for(Map.Entry<Character, Integer> entry : count_a.entrySet()) {
            Character char_a = entry.getKey();
            Integer num_a = entry.getValue();
            Integer num_b = 0;
            if(count_b.containsKey(char_a)) {
                num_b = count_b.get(char_a);
            }
            totalDif += Math.abs(num_a - num_b);
        }

        for(Map.Entry<Character, Integer> entry : count_b.entrySet()) {
            Character char_b = entry.getKey();
            Integer num_b = entry.getValue();
            if(!count_a.containsKey(char_b)) {
                totalDif += num_b;
            }
        }
        return totalDif;
    }
}

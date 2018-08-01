package com.learn.datastructure.hash;
import java.util.*;

public class RansomNote {
    public static void main(String[] args) {
        String[] magazine = "two times three is not four".split(" ");
        String[] note = "two times is four".split(" ");
        System.out.println(checkMagazine(magazine, note));
    }

    static boolean checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineMap = new HashMap();
        for(String ele : magazine) {
            int count = 1;
            if(magazineMap.containsKey(ele)) {
                count += magazineMap.get(ele);
            }
            magazineMap.put(ele, count);
        }

        for(String ele : note) {
            if(!magazineMap.containsKey(ele)) {
                return false;
            } else {
                int count = magazineMap.get(ele) - 1;
                if(count == 0) {
                    magazineMap.remove(ele);
                } else {
                    magazineMap.put(ele, count);
                }
            }
        }
        return true;
    }
}

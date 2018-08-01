package com.learn.datastructure.hash;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> result = new ArrayList();
        Map<Integer,Integer> mapData = new HashMap();
        Map<Integer,Integer> mapFre = new HashMap();
        for(int[] query : queries) {
            int type = query[0];
            int value = query[1];
            if(type == 1) {
                //add value
                mapData.put(value, mapData.getOrDefault(value, 0) +1);
                int fre = mapData.get(value);
                mapFre.put(fre, mapFre.getOrDefault(fre, 0) +1);
                if(fre > 1) {
                    mapFre.put(fre -1 , mapFre.getOrDefault(fre -1 , 0) - 1);
                }
            } else if(type == 2) {
                int fre = mapData.getOrDefault(value, 0);
                if(fre > 1) {
                    mapData.put(value, mapData.getOrDefault(value, 0) - 1);
                    mapFre.put(fre , mapFre.getOrDefault(fre , 0) - 1);
                }
            } else {
                int count = mapFre.getOrDefault(value , 0);
                if(count > 0)
                    result.add(1);
                else
                    result.add(0);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
                bufferedWriter.write(
                        ans.stream()
                                .map(Object::toString)
                                .collect(joining("\n"))
                                + "\n");
            }
        }
    }
}

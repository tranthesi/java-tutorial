package com.learn.algorithm.application;

import java.util.*;

public class LRUCache {
    Map<Integer, Integer> data = new HashMap<>();
    List<Integer> infos = new ArrayList<>();
    int size;

    public LRUCache(int size) {
        this.size = size;
    }

    public void refer(Integer d) {
        if(data.containsKey(d)) {
            //Change item to the first
            infos.remove(d);
            infos.add(0, d);
        } else {
            if(infos.size() == size) {
                Integer old = infos.remove(infos.size() -1);
                data.remove(old);
            }
            data.put(d,d);
            infos.add(0, d);
        }
    }

    public void print() {
        Iterator<Integer> iterator = infos.iterator();
        while ((iterator.hasNext())) {
            Integer i = iterator.next();
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        //1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5
        lruCache.refer(1);lruCache.print();
        lruCache.refer(2);lruCache.print();
        lruCache.refer(3);lruCache.print();
        lruCache.refer(4);lruCache.print();
        lruCache.refer(1);lruCache.print();
        lruCache.refer(2);lruCache.print();
        lruCache.refer(5);lruCache.print();
        lruCache.refer(1);lruCache.print();
        lruCache.refer(2);lruCache.print();
        lruCache.refer(3);lruCache.print();
        lruCache.refer(4);lruCache.print();
        lruCache.refer(5);lruCache.print();
    }
}

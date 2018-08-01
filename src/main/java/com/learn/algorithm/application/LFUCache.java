package com.learn.algorithm.application;

import java.util.*;

public class LFUCache {

    class Item implements Comparable<Item> {
        Integer key;
        Integer fre;

        public Item(Integer key, Integer fre) {
            this.key = key;
            this.fre = fre;
        }

        @Override
        public int compareTo(Item o) {
            return fre.compareTo(o.fre);
        }
    }

    Map<Integer, Integer> data = new HashMap<>();
    int size;
    List<Item> infos = new ArrayList<>();

    public LFUCache(int size) {
        this.size = size;
    }

    public void refer(Integer k) {
        if (data.containsKey(k)) {
            //Increase frequency
            for (int i = 0; i < infos.size(); i++) {
                if (infos.get(i).key == k) {
                    infos.get(i).fre += 1;
                    break;
                }
            }
        } else {
            //Item is full
            if (infos.size() == size) {
                //Remove one with least fre
                Item item = infos.get(0);
                for (int i = 0; i < infos.size(); i++) {
                    if (infos.get(i).fre < item.fre)
                        item = infos.get(i);
                }

                //Remove item data
                data.remove(item.key);
                //Remove from item info
                infos.remove(item);
            }
            data.put(k, k);
            infos.add(new Item(k, 1));
        }
    }

    public void print() {
        Iterator<Item> iterator = infos.iterator();
        while ((iterator.hasNext())) {
            Item i = iterator.next();
            System.out.print(i.key + " ");
        }
        System.out.println();
    }
}

class LFUCacheMain {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        //1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5
        lfuCache.refer(1);
        lfuCache.print();
        lfuCache.refer(2);
        lfuCache.print();
        lfuCache.refer(3);
        lfuCache.print();
        lfuCache.refer(4);
        lfuCache.print();
        lfuCache.refer(1);
        lfuCache.print();
        lfuCache.refer(2);
        lfuCache.print();
        lfuCache.refer(5);
        lfuCache.print();
        lfuCache.refer(1);
        lfuCache.print();
        lfuCache.refer(2);
        lfuCache.print();
        lfuCache.refer(3);
        lfuCache.print();
        lfuCache.refer(4);
        lfuCache.print();
        lfuCache.refer(5);
        lfuCache.print();
    }
}

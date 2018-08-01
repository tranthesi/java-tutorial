package com.learn.algorithm.application.lfu;

public class LFUCache {



}

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

class MinHeap {

    int capacity;
    int size;
    Item[] arr;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new Item[capacity];
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    void heapify(int i) {
        int l = left(i);
        int r = right(i);

        int smallest = i;
        if (l < size && arr[l].fre < arr[i].fre)
            smallest = l;
        if (r < size && arr[r].fre < arr[smallest].fre)
            smallest = r;
        if (smallest != i) {
            Item tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;

            heapify(smallest);
        }
    }

    public Item extractMin() throws Exception {
        if (size == 0)
            throw new Exception();

        Item min = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapify(0);
        return min;
    }

    public void decreaseItem(int i, int new_val) {
        arr[i].fre = new_val;
        while (i != 0 && arr[parent(i)].fre > arr[i].fre) {
            int p = parent(i);
            Item tmp = arr[i];
            arr[i] = arr[p];
            arr[p] = tmp;

            i = p;
        }
    }

    public Item getMin() throws Exception {
        if (size == 0)
            throw new Exception();
        return arr[0];
    }

    void deleteItem(int i) throws Exception {
        decreaseItem(i, Integer.MIN_VALUE);
        extractMin();
    }

    void insertItem(Item k) {
        if (size == capacity)
            return;
        size++;
        int i = size - 1;
        arr[i] = k;

        while (i != 0 && arr[parent(i)].fre > arr[i].fre) {
            int p = parent(i);
            Item tmp = arr[p];
            arr[p] = arr[i];
            arr[i] = tmp;

            i = p;
        }
    }

}
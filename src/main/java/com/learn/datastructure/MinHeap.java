package com.learn.datastructure;

public class MinHeap {
    int[] arr;
    int capacity;
    int size;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    public int parent(int i) {
        return (i-1)/2;
    }

    public int left(int i) {
        return 2*i + 1;
    }

    public int right(int i) {
        return 2*i + 2;
    }

    public void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);

        int smallest = i;
        if( l < size && arr[l] < arr[i])
            smallest = l;
        if( r < size && arr[r] < smallest)
            smallest = r;
        if(smallest != i) {
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;

            MinHeapify(smallest);
        }
    }

    public void insertKey(int k) {
        if(size == capacity)
            return;
        size ++;
        int i = size - 1;
        arr[i] = k;

        while (i != 0 && arr[parent(i)] > arr[i]) {
            int p = parent(i);
            int tmp = arr[p];
            arr[p] = arr[i];
            arr[i] = tmp;

            i = p;
        }
    }

    public void decreaseKey(int i, int newVal) {
        arr[i] = newVal;
        while (i!=0 && arr[parent(i)] > arr[i]) {
            int p = parent(i);
            int tmp = arr[p];
            arr[p] = arr[i];
            arr[i] = tmp;

            i = p;
        }
    }

    public int extractMin() {
        if(size <= 0)
            return Integer.MIN_VALUE;
        if(size == 1) {
            size = 0;
            return arr[0];
        }

        int root = arr[0];
        arr[0] = arr[size-1];
        size --;
        MinHeapify(0);

        return root;
    }

    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public int getMin() { return arr[0]; }

}

class MinHeapMain {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);

        System.out.println(h.extractMin());
        System.out.println(h.getMin());
        h.decreaseKey(2, 1);
        System.out.println(h.getMin());
    }

}

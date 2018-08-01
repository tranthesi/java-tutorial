package com.learn.review.datastructure;

public class MinHeap {
    int capacity;
    int size;
    int[] arr;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity];
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
        if (l < size && arr[l] < arr[i])
            smallest = l;
        if (r < size && arr[r] < smallest)
            smallest = r;
        if (smallest != i) {
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;

            heapify(smallest);
        }
    }

    public int extractMin() throws Exception {
        if (size == 0)
            throw new Exception();

        int min = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapify(0);
        return min;
    }

    public void decreaseKey(int i, int new_val) {
        arr[i] = new_val;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            int p = parent(i);
            int tmp = arr[i];
            arr[i] = arr[p];
            arr[p] = tmp;

            i = p;
        }
    }

    public int getMin() throws Exception {
        if (size == 0)
            throw new Exception();
        return arr[0];
    }

    void deleteKey(int i) throws Exception {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    void insertKey(int k) {
        if (size == capacity)
            return;
        size++;
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
}

class MinHeapMain {
    public static void main(String[] args) throws Exception {
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
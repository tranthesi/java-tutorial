package com.learn.sort;

import java.util.Arrays;

/**
 * Time Complexity: O(n+k)
 * Auxiliary Space: O(n+k)
 * Sorting In Place: Yes
 * Stable: No
 */
public class CountingSort {

    public void sort(char arr[]) {
        int n = arr.length;
        char output[] = new char[n];
        int count[] = new int[256];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for(int i=0; i < n; i++) {
            output[--count[arr[i]]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String args[])
    {
        CountingSort ob = new CountingSort();
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's'
        };

        ob.sort(arr);

        System.out.print("Sorted character array is ");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}

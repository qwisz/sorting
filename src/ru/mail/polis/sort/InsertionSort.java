package ru.mail.polis.sort;

/**
 * Created by Anton on 20.11.2016.
 */
public class InsertionSort {

    public static int[] sort(int[] arr) {
        int minIdx;
        for (int i = 0; i < arr.length; i++) {
            minIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            Helper.swap(arr, i, minIdx);
        }
        return arr;
    }
}

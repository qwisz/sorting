package ru.mail.polis.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anton on 21.11.2016.
 */
public class BFPRP {

//    public static void main(String[] args) {
//        int[] a = {1, 1, 5, 6, 3, 1, -1, 7, 4, 19, 45, 23, 25, 7, 9, 11, 10};
//        System.out.println(select(a, 10));
//        insertSort2(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
//        System.out.println();
//        System.out.println(a[10]);
//    }

    public static int select(int[] a, int w){
        if (a.length <= 5) {
            insertSort2(a);
            return a[w];
        }
        int quant = a.length % 5 == 0 ? a.length / 5 : a.length / 5 + 1;
        int lastSize = a.length % 5;
        int[] medians = new int[quant];
        List<int[]> arrays = new ArrayList<>();
        int i;
        int c = 1;
        int[] tmp;
        for (i = 0; i < a.length; i += 5) {
            if (a.length % 5 == 0 || c < quant) {
                tmp = new int[5];
                for (int j = 0; j < 5; j++) {
                    tmp[j] = a[i + j];
                }
                arrays.add(tmp);
                c++;
            }
            else {
                tmp = new int[lastSize];
                for (int j = 0; j < lastSize; j++) {
                    tmp[j] = a[i + j];
                }
                arrays.add(tmp);
            }
        }
        i = 0;
        for (int[] arr: arrays) {
            insertSort2(arr);
            medians[i] = arr[arr.length / 2];
            i++;
        }
        int x = select(medians, quant / 2);
        int idx = findIdx(a, x);
        partition(a, 0, a.length - 1, x);
        if (w < idx) {
            int[] t = Arrays.copyOfRange(a, 0, idx);
            return select(t, w);
        }
        else if (w > idx) {
            int[] t = Arrays.copyOfRange(a, idx + 1, a.length);
            return select(t, w - idx - 1);
        }
        else
            return x;
    }
    private static int findIdx(int[] a, int x) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                res = i;
                break;
            }
        }
        return res;
    }

    private static void partition(int[] a, int left, int right, int p) {
        int i = left, j = right;
        while (i <= j) {
            while (a[i] < p) {
                i++;
            }
            while (a[j] > p) {
                j--;
            }
            if (i <= j) Helper.swap(a, i++, j--);
        }
//        return j;
    }

    private static void insertSort2(int[] arr) {
        int t, i, j;
        for (i = 0; i < arr.length; i++) {
            t = arr[i];
            for (j = i; j > 0 && arr[j - 1] > t ; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j]  = t;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

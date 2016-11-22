package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by Anton on 21.11.2016.
 */
public class QuickSortRandom {

    public static int[] sort(int[] a) {
        qsort(a, 0, a.length - 1);
        return a;
    }

    private static void qsort(int[] arr, int b, int e)
    {
        int l = b, r = e;
        Random rnd = new Random();
        int index = l + rnd.nextInt(r - l + 1);
//        int piv = arr[(l + r) / 2]; // Опорным элементом для примера возьмём средний
        int piv = arr[index];
        while (l <= r)
        {
            while (arr[l] < piv)
                l++;
            while (arr[r] > piv)
                r--;
            if (l <= r) {
                Helper.swap(arr, l++, r--);
            }
        }
        if (b < r)
            qsort (arr, b, r);
        if (e > l)
            qsort (arr, l, e);
    }    /* ----- end of function qsort ----- */

//    private static void quicksort(int[] a, int l, int r) {
//        if (r <= l)
//            return;
//        Random rnd = new Random();
//        int index = l + rnd.nextInt(r - l + 1);
//        int v = a[index];
//        Helper.swap(a, index, r - 1);
//        int i = l;
//        int j = r - 1;
//        int p = l - 1;
//        int q = r;
//        while (true) {
//            while (a[i] < v)
//                i++;
//            while (a[j] > v)
//                j--;
//            if (i >= j)
//                break;
//            Helper.swap(a, a[i], a[j]);
//            if (a[i] == v) {
//                p++;
//                Helper.swap(a, a[p], a[i]);
//            }
//            if (a[j] == v) {
//                q--;
//                Helper.swap(a, a[q], a[j]);
//            }
//        }
//        Helper.swap(a, a[i], a[r]);
//        j = i - 1;
//        i++;
//        for (int k = 0; k <= p; k++, j--)
//            Helper.swap(a, a[k], a[j]);
//        for (int k = r - 1; k >= q; k--, i++)
//            Helper.swap(a, a[k], a[i]);
//        quicksort(a, 0, j);
//        quicksort(a, i, r);
//    }
}

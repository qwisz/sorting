package ru.mail.polis.sort;

/**
 * Created by Anton on 21.11.2016.
 */
public class MergeSort {

    private static void merge(int[] a, int[] tm, int[] th, int left, int mid, int right) {
        for (int i = left; i <= right; i++)
            tm[i] = a[i];
        int i = left,
                j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid)
                a[k] = tm[j++];
            else if (j > right)
                a[k] = tm[i++];
            else if (tm[j] < tm[i])
                a[k] = tm[j++];
            else
                a[k] = tm[i++];
        }
    }

    private static void msort(int[] a, int[] tm, int[] th, int left, int right) {
        if (left >= right) return;
        int mid = (right + left) / 2;
        msort(a, tm, th, left, mid);
        msort(a, tm, th, mid + 1, right);
        merge(a, tm, th, left, mid, right);
    }

    public static int[] sort(int[] a) {
        int n = a.length;
        int[] tm = new int[n];
        int[] th = new int[n];
        msort(a, tm, th, 0, n - 1);
        return a;
    }
}

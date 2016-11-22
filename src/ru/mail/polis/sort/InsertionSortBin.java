package ru.mail.polis.sort;

/**
 * Created by Anton on 21.11.2016.
 */

public class InsertionSortBin {

    public static int[] sort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int j = i;
            int k = binSearch(a, a[i], -1, j);
            for (int m = j-1; m >= k; m--) {
                Helper.swap(a, m, m + 1);
            }

        }

        return a;
    }

    private static int binSearch(int[] array, int key, int left, int right){

        while (left < right - 1) {                // Запускаем цикл
            int m = (left + right) / 2;            // m — середина области поиска
            if (array[m] < key)
                left = m;
            else
                right = m;                  // Сужение границ
        }
        return right;
    }

    public static void main(String[] args) {

        int[] a = {2,1,1,-2};
        a = sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

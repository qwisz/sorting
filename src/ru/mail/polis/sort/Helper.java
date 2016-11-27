package ru.mail.polis.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    public static int[] genWorstQuickSort(int n){
        int[] res = genBestInsertionSort(n);
        for (int i = 0; i < n; i++) {
            swap(res, i, i / 2);
        }
        return res;
    }

    public static int[] genTest(int n) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(2);
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    public static int[] genWorstInsertionSort(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }
        return a;
    }

    public static int[] genBestInsertionSort(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        return a;
    }
}

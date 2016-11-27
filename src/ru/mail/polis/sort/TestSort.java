package ru.mail.polis.sort;

/**
 * Created by Anton on 22.11.2016.
 */
public class TestSort {
    public static void main(String[] args) {
        int[] a = Helper.genTest(1000);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        a = sort(a);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] sort(int[] a) {
        int[] b = new int[2];
        int[] c = {0 , 0};
        b[0] = a[0];
        c[0]++;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == b[0])
                c[0]++;
            else {
                if (c[1] == 0)
                    b[1] = a[i];
                c[1]++;
            }
        }
        if (b[0] < b[1]) {
            for (int i = 0; i < c[0]; i++) {
                a[i] = b[0];
            }
            for (int i = 0; i < c[1]; i++) {
                a[i + c[0]] = b[1];
            }
        }
        else {
            for (int i = 0; i < c[1]; i++) {
                a[i] = b[1];
            }
            for (int i = 0; i < c[0]; i++) {
                a[i + c[1]] = b[0];
            }
        }
        return a;
    }

    public static int[] sortM(int[] a){
        int i = 1;
        int end = a.length - 1;
        while (i < end){
            if (Integer.compare(a[0], a[i]) != 0){
                swap(a, i, end);
                end--;
            }
            else
                i++;
        }
        return a;
    }

    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

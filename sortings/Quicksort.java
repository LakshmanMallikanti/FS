package sortings;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] a = { 5, 2, 3, 10, 11, 6, 1, 12, 4 };
        sort(a, 0, a.length - 1);
        System.out.print(Arrays.toString(a));
    }

    static void sort(int[] a, int low, int hi) {
        if (low >= hi)
            return;
        int s = low;
        int e = hi;
        int p = low;
        while (s <= e) {
            while (a[s] < a[p])
                s++;
            while (a[e] > a[p])
                e--;
            if (s <= e) {
                int temp = a[s];
                a[s] = a[e];
                a[e] = temp;
                s++;
                e--;
            }
        }
        sort(a, low, e);
        sort(a, s, hi);
    }
}
